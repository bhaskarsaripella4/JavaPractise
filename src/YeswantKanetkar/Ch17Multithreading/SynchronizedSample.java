package YeswantKanetkar.Ch17Multithreading;

class E extends Thread{
    private Output o;
    private String message;
    public E(Output c, String msg){
        o=c;
        message = msg;
    }
    public void run(){
        o.display(message);
    }
}

class Output{
    synchronized void display(String msg){
        System.out.println("["+msg);
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){}
        System.out.println("]");
    }
}

public class SynchronizedSample {
    static public void main(String args[]) throws Exception{
        Output c = new Output();
        E t1 = new E(c,"KICIT");
        t1.start();
        E t2 = new E(c,"Nagpur");
        t2.start();
        E t3 = new E(c,"India");
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
