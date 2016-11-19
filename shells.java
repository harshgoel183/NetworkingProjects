import java.io.BufferedReader;
import java.io.InputStreamReader;

public class shells 
	{
		private static final String[] String = null;

		/**
		 * @param args
		 * @throws Exception 
		 */
		
		
		public static void main(String args[]) throws Exception
		{
			int opt;

			String commandLine;
			BufferedReader console = new BufferedReader
					(new InputStreamReader(System.in));
			//Break with Ctrl+C
			while (true) {
				//read the command
				System.out.print("shell>");
				commandLine = console.readLine();
				//if just a return, loop
				if (commandLine.equals(""))
					continue;
				//help command
				if (commandLine.equals("help"))
				{
					System.out.println();
					System.out.println();
					System.out.println("Welcome to the shell");
					System.out.println("Written by: Tejas Rane");
					System.out.println("CMPE206- Proj");
					System.out.println("--------------------");
					System.out.println("Commands to use:");
					System.out.println("1) -list");
					System.out.println("2) -connect");
					System.out.println("3) -disconnect");
					System.out.println("4) -exit");
					System.out.println("5) -clear");
					System.out.println();
				}
				if (commandLine.equals("-clear"))
				{
					for( int cls = 0; cls < 10; cls++ )
					{	System.out.println();
					}

				}
				if (commandLine.endsWith("-list"))
				{	// call lst function
					
				}
				if (commandLine.equals("exit"))
				{	System.out.println("...Terminating the Virtual Machine");
					System.out.println("...Done");
					System.out.println("Please Close manually with Options > Close");
					System.exit(0);
				}

			}

			}
		

}
