package DesignPatterns.SOLID;

/* Single Operation principle (1 of 5 SOLID)
* It states one class for one task only
* Example is journal*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();
    private int count = 0;

    public void addEntry(String text){
        entries.add("" + (++count) + ":" + text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString(){
        return String.join(System.lineSeparator(), entries);
    }


    /*Adding save and load violates SOP. They do something different from journal entries
    * Thus add them to a new class*/
//    public void save(String filename) throws FileNotFoundException {
//        try(PrintStream out = new PrintStream(filename)){
//            out.println(toString());
//        }
//    }
//    public void load(String filename){};
//    public void load(URL url){};
}

/* storing and loading journals is now a separate class, a separate concern*/

class JournalPersistence{
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException{
        if(overwrite || new File(filename).exists()){
            try(PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }

    public void load(String filename){

    };
    public void load(URL url){};
}


public class SOP{
    public static void main(String[] args) throws Exception{
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        JournalPersistence p = new JournalPersistence();
        String filename = "c:\\temp\\journal.txt";
        p.saveToFile(j,filename,true);

        Runtime.getRuntime().exec("notepad.exe "+filename);
    }
}