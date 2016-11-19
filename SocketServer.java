import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

public class SocketServer
{

	static BufferedWriter bw = null;
	public static void main(String args[]) throws Exception
	{
		listenSocket();			
	}
	public static void listenSocket() throws Exception
	{
		int clientNumber = 0;
		int counter = 0;
		ServerSocket server = new ServerSocket(80);	
		
		try
		{		
			while(true)
		    	{classWorker r = new classWorker(server.accept(),clientNumber);			
		    	Thread t = new Thread(r);
		    	t.start();
		    	OutputStream os = server.accept().getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				pw.println("What's you name?");

				BufferedReader br = new BufferedReader(new InputStreamReader(server.accept().getInputStream()));
				String str = br.readLine();

				pw.println("Hello, " + str);
				pw.close();
				System.out.println("Just said hello to:" + str);
		    	
		    	clientNumber++;}
		}finally{
		    server.close(); }	
		
	}
	public static class classWorker extends Thread
	{
		private Socket server;
		private int clientNumber;
		
		public classWorker(Socket server,int clientNumber)
		{
			this.server = server;
			this.clientNumber = clientNumber;
			
		}
		
		public void run()
		{
			
			try{
			bw = new BufferedWriter(new FileWriter("project.txt", true));
			System.out.println("Connection with client "+clientNumber+" with Socket"+server);
			System.out.println(server.getInetAddress().toString());
			
			bw.write("Slave "+clientNumber+" ");
			bw.write(server.getInetAddress().toString());
			bw.write(" "+server.getLocalPort());
			bw.write(" "+server);
			bw.newLine();
			bw.close();
			}catch (Exception e){e.printStackTrace();}
			finally{
				try{
					server.close();
				   }catch (IOException e){}
				}
			}
		}
}