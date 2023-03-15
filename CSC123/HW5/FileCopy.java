//Pedro Nunez (pnunez14@toromail.csudh.edu)

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {

        if(args.length < 2) {
            System.out.println("You are missing an argument");
            System.exit(0);
        }
        File sourceFile = new File(args[0]);

        File targetFile = new File(args[1]);

        PrintWriter writer = null;
        try {
            if(sourceFile.isDirectory()||targetFile.isDirectory()) {
                System.out.println("Error! Either Your sourceFile or targetFile is a Directory. Try again");
                System.exit(0);
            }

            if(!sourceFile.exists()) {
                System.out.println("Error! Your source file doesn't exist! ");
                System.exit(0);
            }

            if(!targetFile.exists())
                targetFile.createNewFile();
            else {
                System.out.println("File already exsits");
                System.exit(0);
            }

            File parent = targetFile.getParentFile();
            if(!parent.exists())parent.mkdirs();

            InputStream reader = new FileInputStream(sourceFile); 

            OutputStream writ = new FileOutputStream(targetFile);

            byte[] buff = new byte[4096];
            int Byte;

            while((Byte = reader.read(buff))!=-1) {
                writ.write(buff, 0, Byte);   
            }

            System.out.println(sourceFile.length()+ "bytes successfully copied from "+sourceFile+ " to "+targetFile);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (IOException b) {
            System.out.println(b.getMessage());
        }
        finally {
            if(writer!=null)writer.close();
        }
    }
}
