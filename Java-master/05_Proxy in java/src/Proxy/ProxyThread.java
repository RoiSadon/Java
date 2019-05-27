package Proxy;

import java.io.*;
import java.net.*;

public class ProxyThread extends Thread{
	Socket socket;
	
	public ProxyThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// Reads text from a character-input stream
			BufferedReader reader = new BufferedReader(new InputStreamReader((socket.getInputStream())));
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			
			// 1. Read request
			HTTPRequest request = new HTTPRequest(reader);
			
			if(!"GET".equals(request.method)) {
				socket.close();
				return;
			}
			else {
				System.out.println("* "+request);
			}
			
			// 2. Send req to real host and get response
			HTTPResponse response = request.getResponse();
			
			// 3. Send back res to client
			response.send(outputStream);
			
			// 4. Close connection
			reader.close();
			outputStream.close();
		}
		catch(Exception e){
			System.out.println("* "+e);
			e.printStackTrace();
		}
		try {
			socket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
