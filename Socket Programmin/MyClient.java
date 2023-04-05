    import java.net.*;  
    import java.io.*;  
    class MyClient{  
    public static void main(String args[])throws Exception{  
	    	// created objectr of socket class in client side
		Socket s=new Socket("localhost",3333);  
	    
	    	//created object for input and output stream
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
      
		String str="",str2="";  
	    	//loop termninates when client says "stop"
		while(!str.equals("stop")){  
			
			//read message from client
			str=br.readLine();  
			//write message to server
			dout.writeUTF(str);  
			dout.flush();  
			//read message sent by server
			str2=din.readUTF();  
			//print the message sent by server
			System.out.println("Server says: "+str2);  
		}  
      		//close the connection
		dout.close();  
		s.close();  
    }
}	
