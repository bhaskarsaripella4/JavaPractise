package DesignPatterns.Singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){
        System.out.println("initializing a lazy singleton");
    }

    /* an unsynchronized method can be called from multiple threads causing a race condition*/
//    public static LazySingleton getInstance(){
//
//        if(instance == null){
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

//    public static synchronized LazySingleton getInstance(){
//        if(instance == null){
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    // double-checked locking, best practise.
    public static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }
}
