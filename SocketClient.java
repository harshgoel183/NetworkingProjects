import java.io.*;
import java.net.*;
public class SocketClient
{
	public static void main(String args[]) throws Exception
	{
		for(int i = 0; i < 50; i++)
		{listenSocket b = new listenSocket();}
	}
	public static class listenSocket 
	{
		public Socket socket;
		public listenSocket()
		{
	
			try{
				socket = new Socket();	 	
				socket.connect(new InetSocketAddress("www.google.com",80));
				if(socket.isConnected())
				{
					System.out.println("Connected to"+socket.toString());
				}
				System.out.println("after connecting");
		        System.out.println("local port"+socket.getLocalPort()+"\n port"+socket.getPort()+"\n local address"+socket.getLocalAddress()+"\n iNetaddress"+socket.getInetAddress());
		        System.out.println("local socket address"+socket.getLocalSocketAddress()+"\n");
			}catch (Exception e){}
			finally{
				try{
					socket.close();
				   }catch (IOException e){}
				}
		}
	}
}