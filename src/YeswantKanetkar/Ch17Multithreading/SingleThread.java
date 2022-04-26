// Read files in a single thread
package YeswantKanetkar.Ch17Multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;

public class SingleThread {
    public static void main(String args[]) throws Exception{
        System.out.println("Starting time: "+System.currentTimeMillis());
        for(int i=0;i< args.length;i++){
            FileReader fr = new FileReader(args[i]);
            BufferedReader br = new BufferedReader(fr);
            LineNumberReader l = new LineNumberReader(br);

            while(l.readLine()!=null){
                Thread.sleep(10);
            }
            System.out.println("Lines in "+args[i] + ":" + l.getLineNumber());
        }

        System.out.println("Ending time: "+ System.currentTimeMillis());

    }
}
