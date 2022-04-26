package YeswantKanetkar.Ch17Multithreading;
import java.io.*;

public class MultiThread {
    static public void main(String args[]) throws Exception{
        System.out.println("Starting time: "+System.currentTimeMillis());
        linecounter t[] = new linecounter[args.length];
        for(int i = 0; i< args.length; i++){
            t[i] = new linecounter(args[i]);
            t[i].start();
        }

        for(int i = 0; i< args.length;i++){
            t[i].join();

        }
        System.out.println("Ending Time: "+System.currentTimeMillis());
    }
}

class linecounter extends Thread{

    String fname;
    linecounter(String str){
        fname = str;
    }

    public void run(){
        try{
            FileReader fr = new FileReader(fname);
            BufferedReader br = new BufferedReader(fr);
            LineNumberReader l = new LineNumberReader(br);
            while(l.readLine()!=null){
                Thread.sleep(10);
            }
            System.out.println("Lines: "+fname+":"+l.getLineNumber());
        }
        catch(Exception e){}
    }
}