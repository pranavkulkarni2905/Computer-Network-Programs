    import java.net.*;  
    import java.io.*;  
    class MyServer{  
		public static void main(String args[])throws Exception{  
			
			//created object of serversocket class and passed one port number port number must be onwards 1024
			ServerSocket ss=new ServerSocket(3333);  
			
			//accepting request sent by client
			Socket s=ss.accept();  
			
			//created object for output and input class
			DataInputStream din=new DataInputStream(s.getInputStream());  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			  
			String str="",str2="";  
			
			//terminates when client says "stop"
			while(!str.equals("stop")){  
				//read the message sent by client
				str=din.readUTF();  
				//print the message sent by client
				System.out.println("client says: "+str);  
			
				str2=br.readLine();  
				
				//write the response to the client
				dout.writeUTF(str2);  
				dout.flush();  
			}  
		din.close();  
		s.close();  
			//close the connection
		ss.close();  
    }
}  
