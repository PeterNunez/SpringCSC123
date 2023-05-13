import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DirectoryAnalyzer {

	//These are my fields for now
	private static String Al= "Alpha";
	private static String Nu = "Numeric";
	private static String Sp = "Space";
	private static int ByteKB = 1024;
	private static int ByteMB = ByteKB * 1024;
	private static int ByteGB = ByteMB * 1024;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File direct = new File(args[0]);
		if (!direct.exists() || !direct.isDirectory())
			throw new IOException("Directory '%s' does not exist!%n".format(direct.getName()));

		File[] files = direct.listFiles();
		long totalS = 0;
		long totalA = 0;
		long totalN = 0;
		long totalSp = 0;

		System.out.println("File Name\tSize\t\tAlpha\t\tNumeric\t\tSpace\n");

		for (File f : files) {
			if (f.isFile()) {
				InputStream in = new FileInputStream(f);
				int fileSize = in.available();
				Map<String, Integer> m = counting(in);

				System.out.println(String.format("%s	%s bytes	 %s		  %s		  %s", f.getName(), fileSize,
						m.get(Al), m.get(Nu), m.get(Sp)));

				totalS += fileSize;
				totalA += m.get(Al);
				totalN += m.get(Nu);
				totalSp += m.get(Sp);
			}
	}
		
		System.out.println(String.format("\nTotal Files		: %s\n", files.length));
		System.out.println(String.format("Total Alpha Chars	: %s\n", totalA));
		System.out.println(String.format("Total Numeric		: %s\n", totalN));
		System.out.println(String.format("Total Spaces		: %s\n", totalSp));
		System.out.println(String.format("Total Size on Disk: %s\n", formatSize(totalS)));
	}
		
		private static Map<String, Integer> counting (InputStream in) throws IOException {

			Map<String, Integer> m = new HashMap<String, Integer>();
			m.put(Al, 0);
			m.put(Nu, 0);
			m.put(Sp, 0);

			byte b;

			while ((b = (byte) in.read()) != -1) {
				char c = (char) b;
				if (c == ' ')
					m.put(Sp, m.get(Sp) + 1);
				if (Character.isAlphabetic(c))
					m.put(Al, m.get(Al) + 1);
				if (Character.isDigit(c))
					m.put(Nu, m.get(Nu) + 1);
			}

			return m;

		}
		//this would format and return all the bytes we have been working with
		private static String formatSize(long bytes) {
			if(bytes/ByteGB>=1) {
				return String.format("%.2f GB" ,(double)bytes/ByteGB);
			}
			else if(bytes/ByteMB>=1) {
				return String.format("%.2f MB" ,(double)bytes/ByteMB);
			}
			else if(bytes/ByteKB>=1) {
				return String.format("%.2f KB" ,(double)bytes/ByteKB);
			}
			else{
				return String.format("%s bytes" ,bytes);
			}
			
		}

}
