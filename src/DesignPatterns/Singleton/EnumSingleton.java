package DesignPatterns.Singleton;

import java.io.*;

enum EnumBasedSingleton{
    /* like a class but enum can only have finite Instances
    * Serialization by default, but not members. Only name of instance is serialized.
    * Cannot inherit from this class
    * Not persistable*/
    INSTANCE;
    /* others cannot make instances of enum hence constructor is optional
    * it is private to enum hence no use making it public*/
    EnumBasedSingleton(){
        value = 42;
    }

    private int value;
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }
}

class EnumSingletonDemo{
    static void saveToFile(EnumBasedSingleton singleton, String filename) throws Exception{
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(singleton);
        } catch (Exception e) {
            System.err.println("Saving to file failed");
        }
    }

    static EnumBasedSingleton readFromFile(String filename) throws Exception{
        try(FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (EnumBasedSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        String filename = "myfile.bin";
//        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
//        singleton.setValue(111);
//        saveToFile(singleton,filename);

        EnumBasedSingleton singleton2 = readFromFile(filename);
        System.out.println(singleton2.getValue());


    }
}


