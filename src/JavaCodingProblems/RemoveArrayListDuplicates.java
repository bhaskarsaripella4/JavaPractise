package JavaCodingProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveArrayListDuplicates {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(30);
        list.add(10);
        list.add(30);
        list.add(70);
        list.add(100);
        list.add(50);
        System.out.println(list);
        HashSet set = new LinkedHashSet();
        set.addAll(list);
        System.out.println(set);

        list.clear();
        list.addAll(set);

        System.out.println(list);
    }


}
