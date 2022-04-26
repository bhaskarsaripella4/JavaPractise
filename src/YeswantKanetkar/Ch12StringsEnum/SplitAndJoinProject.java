package YeswantKanetkar.Ch12StringsEnum;

import java.io.File;

public class SplitAndJoinProject {
    public static void main(String[] args) throws Exception{
        File f = new File(".");
        String d = f.getCanonicalPath();
        String[] parts = d.split("\\\\");
        System.out.println("complete path: "+d);
        System.out.println("Dir name: "+parts[parts.length-2]);
    }
}


