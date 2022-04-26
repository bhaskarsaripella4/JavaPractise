package YeswantKanetkar.Ch17Multithreading;

public class MainThread {
    public static void main(String args[]){
        Thread t = Thread.currentThread();
        System.out.println("Current thread: "+t);
        t.setName("mythread");
        System.out.println("Name after change: "+t);
        String s = t.getName();
        System.out.println("thread name: "+s);
    }
}
