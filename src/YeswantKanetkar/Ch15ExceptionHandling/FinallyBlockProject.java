package YeswantKanetkar.Ch15ExceptionHandling;
import java.io.*;

import java.io.FileWriter;

public class FinallyBlockProject {
    public static void main(String[] args){
        FileWriter fw = null;
        try{
            fw = new FileWriter("a.txt");
            fw.write("Hello World\n");
        }
        catch(IOException ie){
            System.out.println("Encountered IO error");
        }

        finally{
            try{
                if(fw!=null) fw.close();
            }
            catch(IOException e){
                System.out.println("Error in input");
            }
        }
    }
}
