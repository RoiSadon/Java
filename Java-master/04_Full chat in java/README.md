# Chat in java:
___
## Example:
![picture](1.png)
## Server:
1. import:
    * java.io.*;   (IOException, ObjectOutputStream, InputStream, PrintStream)
    * java.net.*;  (ServerSocket, Socket)
    * java.util.*; (ArrayList, List, regex(pattern,match), Scanner, awt.Color)

2. class Server:
    * constructor: gets port, and initializes port and new ArrayList of 'User' class called - 'clients'
    * main: creates new Server with port(12345) and run() function on it.
    * run() function:
        * initializes new ServerSocket - with port, named - 'server', with inside function - 'finalize' - will close 'server'
        * inside loop:
            * 'client' of type Socket - will start with accept(); - accept new client
            * get nickname from user: new Scanner - from inputStream, and replace ' ' to '_' & ',' to ''
            * create new User. 
            * add newUser to 'clients' List. 
            * welcome message
            * new Thread for newUser to handle incoming message
    * removeUser() - delete user from the list
    * broadcastMessages() - send imcoming message to all users
    * broadcastAllUser()  - send list of clients to all users
    * sendMessageToUser() - send message to user. (find nickname in list)
 
3. class UserHandler: (implements Runnable)
    * constructor: server, user & activate server to - broadcastAllUsers()
    * run() 
        * new Scanner - will get input. 
        * smily
        * send private message using '@'
        * change color if charat(0)=='#'
        * close thread of person that sends message

3. class User:
    * constructor: streamOut, streamIn, client, nickName, nbUser(+1), color. 
    * change user's color (if too bright - keep it)

4. class ColorInt:
    * string of colors. 
    * getColor() - function to return color according to it's number. 
## Client:
1. import:
    * java.io.*;   (IOException, InputStream, PrintStream, stringReader)
    * java.net.*;  (unknownHostException, Socket)
    * java.util.*; (ArrayList, List, Scanner)

2. class Client:
    * constructor: host & port.
    * main: creates new client with localhost + port 12345. run() function on it.
    * run() function:
        * initializes new socket named 'client' (host,port)
        * get socket output stream. 
        * ask for nickname. (bu scanner)
        * send nickname to server
        * create new Thread (uses 'receiveMessageHandler' function that implements 'Runnable' and run 'start()')
        * read messages from keyboard and send to server. 
        * close connection when 'ctrl+d' occurs.
 
3. class receiveMessageHandler:
    * implements 'Runnable' interface. 
    * constructor: server. 
    * run(): 
        * new Scanner. 
        * while there is text to send - show to screen. 
        * print out 'USERS LIST' 
        * close scanner. 

