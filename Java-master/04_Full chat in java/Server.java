package Chat;

import java.awt.Color;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
	private int port;
	private List<User> clients;
	private ServerSocket server;
	
	public Server(int port) {
		this.port = port;
		this.clients = new ArrayList<User>();
	}
	
	private void run() throws IOException {
		server = new ServerSocket(port) {
			protected void finalize() throws IOException{
				this.close();
			}
		};
		System.out.println("Port 12345 is now open.");
		
		while(true) {
			// Accept new client:
			Socket client = server.accept();
			
			// Get nickname:
			String nickname = (new Scanner(client.getInputStream())).nextLine();
			nickname = nickname.replace(",", ""); // replaces substring in tav.
			nickname = nickname.replace(" ", "_");
			System.out.println("New client: \""+nickname+"\"\"\n\t    Host:"+client.getInetAddress().getHostAddress());
		
			// Create new user:
			User newUser = new User(client,nickname);
			
			// Add newUser message to list:
			this.clients.add(newUser);
			
			// Welcome message:
			newUser.getOutStream().println(
					"<img src='https://www.ctvnews.ca/polopoly_fs/1.4037876!/httpImage/image.jpg_gen/derivatives/landscape_1020/image.jpg' height='42' width='42'>"
					+ "<b>Welcome</b>" + newUser.toString() + "<img src='https://www.ctvnews.ca/polopoly_fs/1.4037876!/httpImage/image.jpg_gen/derivatives/landscape_1020/image.jpg' height='42' width='42'>"
					);
			
			// create new thread for newUser incoming messages handling:
			new Thread(new UserHandler(this,newUser)).start();
		}
	}
	
	// Delete a user from the list:
	public void removeUser(User user) {
		this.clients.remove(user);
	}
	
	// Send incoming message to all users:
	public void broadcastMessages(String msg, User userSender) {
		for(User client:this.clients) {
			client.getOutStream().println(userSender.toString()+"<span>: "+msg+"</span>");
		}
	}
	
	// Send list of clients to all users
	public void broadcastAllUsers() {
		for(User client:this.clients) {
			client.getOutStream().println(this.clients);
		}
	}
	
	// Send message to a user:(String)
	public void sendMessageToUser(String msg, User userSender, String user) {
		boolean find = false;
		for(User client:this.clients) {
			if(client.getNickName().equals(user)&&client!=userSender) {
				find = true;
				userSender.getOutStream().println(userSender.toString()+" -> "+client.toString()+": "+msg);
				client.getOutStream().println("(<b>Private</b>)"+userSender.toString()+"<span>: "+msg+"</span>");
			}
		}
		if(!find) {
			userSender.getOutStream().println(userSender.toString()+" -> (<b>no one!</b>): "+msg);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Server(12345).run();
	}
}


class UserHandler implements Runnable{

	private Server server;
	private User user;
	
	
	
	public UserHandler(Server server, User user) {
		this.server = server;
		this.user = user;
		this.server.broadcastAllUsers();
	}

	@Override
	public void run() {
		String message;
		
		// for new message - broadcast to all
		Scanner sc = new Scanner(this.user.getInputStream());
		while (sc.hasNextLine()) {
			message = sc.nextLine();
			
			// Smily:
			message = message.replace(":)", "<img src='http://4.bp.blogspot.com/-ZgtYQpXq0Yo/UZEDl_PJLhI/AAAAAAAADnk/2pgkDG-nlGs/s1600/facebook-smiley-face-for-comments.png'>");
		      message = message.replace(":D", "<img src='http://2.bp.blogspot.com/-OsnLCK0vg6Y/UZD8pZha0NI/AAAAAAAADnY/sViYKsYof-w/s1600/big-smile-emoticon-for-facebook.png'>");
		      message = message.replace(":d", "<img src='http://2.bp.blogspot.com/-OsnLCK0vg6Y/UZD8pZha0NI/AAAAAAAADnY/sViYKsYof-w/s1600/big-smile-emoticon-for-facebook.png'>");
		      message = message.replace(":(", "<img src='http://2.bp.blogspot.com/-rnfZUujszZI/UZEFYJ269-I/AAAAAAAADnw/BbB-v_QWo1w/s1600/facebook-frown-emoticon.png'>");
		      message = message.replace("-_-", "<img src='http://3.bp.blogspot.com/-wn2wPLAukW8/U1vy7Ol5aEI/AAAAAAAAGq0/f7C6-otIDY0/s1600/squinting-emoticon.png'>");
		      message = message.replace(";)", "<img src='http://1.bp.blogspot.com/-lX5leyrnSb4/Tv5TjIVEKfI/AAAAAAAAAi0/GR6QxObL5kM/s400/wink%2Bemoticon.png'>");
		      message = message.replace(":P", "<img src='http://4.bp.blogspot.com/-bTF2qiAqvi0/UZCuIO7xbOI/AAAAAAAADnI/GVx0hhhmM40/s1600/facebook-tongue-out-emoticon.png'>");
		      message = message.replace(":p", "<img src='http://4.bp.blogspot.com/-bTF2qiAqvi0/UZCuIO7xbOI/AAAAAAAADnI/GVx0hhhmM40/s1600/facebook-tongue-out-emoticon.png'>");
		      message = message.replace(":o", "<img src='http://1.bp.blogspot.com/-MB8OSM9zcmM/TvitChHcRRI/AAAAAAAAAiE/kdA6RbnbzFU/s400/surprised%2Bemoticon.png'>");
		      message = message.replace(":O", "<img src='http://1.bp.blogspot.com/-MB8OSM9zcmM/TvitChHcRRI/AAAAAAAAAiE/kdA6RbnbzFU/s400/surprised%2Bemoticon.png'>");
		      
		      // Send messages private
		      if(message.charAt(0)=='@') {
		    	  if(message.contains(" ")) {
		    		   System.out.println("Private message : "+message);
		    		   int firstSpace = message.indexOf(" ");
		    		   String userPrivate = message.substring(1,firstSpace);
		    		   server.sendMessageToUser(message.substring(firstSpace+1, message.length()),user,userPrivate);		   
		    	  }		    	  
		      }
		      
		      // Send message to changement
		      else if(message.charAt(0)=='#') {
		    	  user.changeColor(message);
		    	  // Update color for all the users:
		    	  this.server.broadcastAllUsers();
		      }
		      else {
		    	  // Update user list
		    	  server.broadcastMessages(message, user);
		      }
		}
		// End of thread
		server.removeUser(user);
		this.server.broadcastAllUsers();
		sc.close();
	}
}

class User{
	private static int nbUser = 0;
	private int userId;
	private PrintStream streamOut;
	private InputStream streamIn;
	private String nickName;
	private Socket client;
	private String color;
	
	// Constructor: 
	public User( Socket client, String name) throws IOException {
		this.userId = nbUser;
		this.streamOut = new PrintStream(client.getOutputStream());
		this.streamIn = client.getInputStream();
		this.nickName = name;
		this.client = client;
		this.color = ColorInt.getColor(this.userId);
		nbUser +=1;
	}

	// Change user color:
	public void changeColor(String hexColor) {
		// Check if it's a valid hexColor
		Pattern colorPattern = Pattern.compile("#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})");
		Matcher m = colorPattern.matcher(hexColor);
		if(m.matches()) {
			Color c = Color.decode(hexColor);
			// If color is too bright don't change
			double luma = 0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue();
			if(luma>160) {
				this.getOutStream().println("<b>Color too bright</b>");
				return;
			}
			this.color = hexColor;
			this.getOutStream().println("<b>Color changed succesfully</b>"+this.toString());
			return;
		}
		this.getOutStream().println("<b>Failed to change color</b>");
	}
	
	public PrintStream getOutStream() {
		return this.streamOut;
	}
	
	public InputStream getInputStream() {
		return this.streamIn;
	}

	public String getNickName() {
		return this.nickName;
	}
	
	// print user + color
	public String toString() {
		return "<u><span style='color':" + this.color + "'>"+this.getNickName()+"</span></u>";
	}
}

class ColorInt{
	public static String[] mColor = {
	    "#3079ab", // dark blue
        "#e15258", // red
        "#f9845b", // orange
        "#7d669e", // purple
        "#53bbb4", // aqua
        "#51b46d", // green
        "#e0ab18", // mustard
        "#f092b0", // pink
        "#e8d174", // yellow
        "#e39e54", // orange
        "#d64d4d", // red
        "#4d7358", // green
	};
	
	public static String getColor(int i) {
		return mColor[i % mColor.length];
	}
}