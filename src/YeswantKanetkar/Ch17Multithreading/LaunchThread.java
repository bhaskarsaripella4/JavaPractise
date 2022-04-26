package YeswantKanetkar.Ch17Multithreading;

class Ex implements Runnable{
    public Thread x;

    Ex(String n){
        x = new Thread(this, n);
    }

    public void run(){
        int i;
        for(i=0;i<5;i++){
            System.out.println(x.getName());
        }
    }
}

//class Ex extends Thread{
//    public void run(){
////        for(int i = 0; i <5;i++){
////            System.out.println("New Thread");
//
//        try{
//            for(int i=0;i<5;i++){
//                System.out.println("New thread");
//                Thread.sleep(1000);
//            }
//
//        }
//        catch(Exception e){}
//    }
//}

public class LaunchThread {
    public static void main(String args[]){
        Ex t = new Ex("One");
        t.x.start();
//        for(int i = 0; i<5; i++) System.out.println("Main thread");
        try{
            for(int i = 0; i<5; i++){
                System.out.println("Main Thread");
            }
        }
        catch(Exception e){}
    }
}
