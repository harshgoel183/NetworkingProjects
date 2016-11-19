
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleTest {
	 private static void printLines(String name, InputStream ins) throws Exception {
		    String line = null;
		    BufferedReader in = new BufferedReader(
		        new InputStreamReader(ins));
		    while ((line = in.readLine()) != null) {
		        System.out.println(name + " " + line);
		    }
		  }

		  private static void runProcess(String command) throws Exception {
		    Process pro = Runtime.getRuntime().exec(command);
		    printLines(command + " stdout:", pro.getInputStream());
		    printLines(command + " stderr:", pro.getErrorStream());
		    //printLines(command + " stdout:", pro.getOutputStream());
		    pro.waitFor();
		    System.out.println(command + " exitValue() " + pro.exitValue());
		  }

		  public static void main(String[] args) {
		    try {
		    	String current = System.getProperty("user.dir");
		    	System.out.println(current);
		      runProcess("javac src\\MasterBot.java");
		      runProcess("java -classpath C:\\Users\\Harsh\\workspace\\Networking\\src\\ MasterBot");
		      runProcess("javac src\\SlaveBot.java");
		      runProcess("java -classpath C:\\Users\\Harsh\\workspace\\Networking\\src\\ SlaveBot");
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
}
