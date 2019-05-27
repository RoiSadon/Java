package Proxy;

import java.io.*;
import java.net.*;
import java.net.http.HttpResponse;
import java.util.*;

public class HTTPRequest {
	int port = 80;
	String method = "GET";
	String path = "/";
	String version = "HTTP/1.0";
	
	HashMap<String, String> headers = new HashMap<String, String>();
	
	// used for getResponse()
	Socket socket;
	DataOutputStream outputStream;
	BufferedReader reader;
	
	public HTTPRequest(BufferedReader reader) throws Exception {
		String reqLine = reader.readLine();
		
		if(reqLine == null) {
			throw new Exception("Invalid request!");
		}
		
		String[] split = reqLine.split(" ");
		method = split[0];
		path   = split[1];
		version= split[2];
		
		// PROXY: path may contain host too (Example: path=http://foo.com/bar)
		try {
			URL url = new URL(path);
			path = url.getPath();
			headers.put("Host",url.getHost());			
		}
		catch(Exception e){
			// Do nothing
		}
		
		headers.put("Connection","close");
	}
	
	HTTPResponse getResponse() throws Exception{
		
		// 1. Get host addr. using DNS and connect:
		InetAddress address = InetAddress.getByName((headers.get("Host")));
		
		System.out.println("REQ: Connecting to "+address);
		
		socket = new Socket(address,port);
		outputStream = new DataOutputStream(socket.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// 2. Send requests:
		write(method + " "+path+" "+version);
		
		for (String key:headers.keySet()) {
			write(key + ": "+ headers.keySet());
		}
		write("");
		
		// 3. Read response:
		HTTPResponse response = new HTTPResponse(reader);
		return response;
				
	}

	private void write(String line) throws Exception {
		System.out.println("REQ > "+line);
		outputStream.writeBytes(line+"\n\n");
		outputStream.flush();
	}
	@Override
	public String toString() {
		return "[REQUEST] " + method + " " + "Path: " + path + " " + "Version: " + version;
	}
	
}

























