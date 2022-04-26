package DesignPatterns.Singleton;

import java.io.*;

public class BasicSingleton implements Serializable {

    // private constructor makes sure no one can create a class
    // Hence create a single instance here itself and final it.
    private BasicSingleton(){

    }

    // One final instance of the above class. Singleton
    private static final BasicSingleton INSTANCE = new BasicSingleton();

    // return the instance usint getInstance method. This is singleton pattern.
    public static BasicSingleton getInstance(){
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Object readResolve(){
        return INSTANCE;
    }

}
/*
* 1. with reflections, you can access the private constructor defeating the purpose of singleton.
*  import java.lang.reflect.Constructor;
*   public class Example{
*   public static void main(final String[] args) throws Exception{
*       Constructor<Foo> constructor = Foo.class.getDeclaredConstructor();
*       constructor.setAccessible(true);
*       Foo foo = constructor.newInstance();
*       System.out.println(foo);
*
* class Foo{
*   private Foo(){} -> a private constructor like our singleton class constructor
*
* */
/* 2. Serialization or writing and reading from file. TO solve return Instance from ReadResolver method
* Let class implement Serializable. Then override ReadResolver and return iNstance
* Serialization can create new instances of the classes as JVM does not care for the private keyword
* Thus readResolve forces the JVM to use the created instance when reading from file. */


class BasicSingletonDemo{

    static void saveToFile(BasicSingleton singleton, String filename) throws Exception{
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception{
        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);

        String filename = "singleton.bin";
        saveToFile(singleton, filename);
        singleton.setValue(234);

        BasicSingleton singleton2 = readFromFile(filename);
        System.out.println(singleton == singleton2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());


    }
}



