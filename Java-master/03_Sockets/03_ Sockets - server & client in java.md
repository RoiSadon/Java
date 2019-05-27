# Server:
```java
package B;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	
	// Constructor:
	public Server(int port)
	{
		try 
		{
			server = new ServerSocket(port);
			System.out.println("Server started in port " + port);
			System.out.println("Waiting for client...");
			
			socket = server.accept();
			System.out.println("Client accepted");
			
			// input from client socket:
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String line = "";
			
			// read message until "End" is sent:
			while(!line.equals("End"))
			{
				try 
				{
					line = in.readUTF();
					System.out.println(line);
				}
				catch(IOException e) {
					System.out.println(e);
				}
			}
			System.out.println("Closing connection");
			
			// close connection:
			socket.close();
			in.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		Server s = new Server(5000);
	}
}

```
# Client:
```java
package B;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Client {
	
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	
	public Client(String ip, int port) {
		try
		{
			socket = new Socket(ip,port);
			System.out.println("Connected");
			
			input = new DataInputStream(System.in);
			
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException e) {
			System.out.println(e);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		String line = "";
		
		while(!line.equals("End"))
		{
			try
			{
				line = input.readLine();
				out.writeUTF(line);
			}
			catch(IOException e) {
				System.out.println(e);
			}
		}
		
		try
		{
			input.close();
			out.close();
			socket.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		Client c = new Client("127.0.0.1",5000);
	}
}

```