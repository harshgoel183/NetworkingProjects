import java.io.*;
import java.net.*;
public class pingTogoogle {
    public static void main(String[] args) throws IOException 
    {
        Socket s = new Socket();
        System.out.println("default data");
        System.out.println("local port"+s.getLocalPort()+"\n port"+s.getPort()+"\n local address"+s.getLocalAddress()+"\n iNetaddress"+s.getInetAddress());
        System.out.println("local socket address"+s.getLocalSocketAddress()+"\n");
        String host = "www.google.com";
       
        
         System.out.println("hi");
        try
        {
        	System.out.println(s);
        s.connect(new InetSocketAddress(host , 80));
        if(s.isConnected()){
        	System.out.println("Connected to"+s.toString());
        }
        //s2.connect(new InetSocketAddress(harsh , 51680));
        System.out.println("after connecting");
        System.out.println("local port"+s.getLocalPort()+"\n port"+s.getPort()+"\n local address"+s.getLocalAddress()+"\n iNetaddress"+s.getInetAddress());
        System.out.println("local socket address"+s.getLocalSocketAddress()+"\n");
        
        }
         
        //Host not found
        catch (UnknownHostException e) 
        {
            System.err.println("Don't know about host : " + host);
            System.exit(1);
        }finally{
        	s.close();
        }
         
         
    }
}
