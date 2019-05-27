package Chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	private String host;
	private int port;
	
	// Constructor:
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void run()throws UnknownHostException,IOException {
		// Connect client to server:
		Socket client = new Socket(host,port);
		System.out.println("Client connected succesfully to server...");
		
		// Get socket output stream:
		PrintStream output = new PrintStream(client.getOutputStream());
		
		// Ask for nickName:
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter nickname: ");
		String nickname = sc.nextLine();
		
		// Send nickName to server:
		output.println(nickname);
		
		// Create new Thread for server messages hanlding:
		new Thread(new ReceiveMessagesHanlder(client.getInputStream())).start();
		
		// Read messages from keyboard and send to server:
		System.out.println("Messages: \n");
		
		// While new messages:
		while(sc.hasNextLine()) {
			output.println(sc.nextLine());
		}
		
		// End ctrl+d
		output.close();
		sc.close();
		client.close();
	}

	public static void main(String[] args) throws UnknownHostException,IOException{
		new Client("127.0.0.1",12345).run();
	}
	
}


class ReceiveMessagesHanlder implements Runnable{

	private InputStream server;
	
	ReceiveMessagesHanlder(InputStream server) {
		this.server = server;
	}

	@Override
	public void run() {
		// Recieve server messages and print out to screen:
		Scanner s = new Scanner(server);
		String tmp = "";
		
		while(s.hasNextLine()) {
			tmp = s.nextLine();
			if(tmp.charAt(0)=='[') {
				tmp = tmp.substring(1,tmp.length()-1);
				System.out.println("\nUSERS LIST: "+ new ArrayList<String>(Arrays.asList(tmp.split(",")))+"\n");
			}
			else {
				try {
					System.out.println("\n"+getTagValue(tmp));
				}
				catch (Exception ignore) {}
			}
		}
		s.close();
	}
	
	public static String getTagValue(String xml) {
		return xml.split(">")[2].split("<span>")[1].split("</span>")[0];
	}
	
}