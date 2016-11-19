import java.io.*;
import java.net.*;

public class SocketClient2 
{
		static Socket socket;
		public static void main(String args[])
		{
			
				try{
					socket = new Socket("192.168.30.1",80);   
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

					System.out.println("server says:" + br.readLine());

					BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
					String userInput = userInputBR.readLine();

					out.println(userInput);

					System.out.println("server says:" + br.readLine());

					if ("exit".equalsIgnoreCase(userInput)) {
						socket.close();
						
					}
			   } catch (IOException e) {
			     System.out.println("Unknown host: kq6py");
			     System.exit(1);}
		}
}

