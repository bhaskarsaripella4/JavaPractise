package DesignPatterns.Singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton{

    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".",".");
    }

    private static StaticBlockSingleton instance;

    static{
        try{
            instance = new StaticBlockSingleton();
        }
        catch (IOException e) {
            System.err.println("Static block initialization failed");
        }
    }
}

/* static block loads when JVM initializes Class definitions or loaded into memory
* best for static member initialization.
* better to avoid static member initialization via constructors, instead do via block
* */
