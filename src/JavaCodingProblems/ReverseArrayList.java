package JavaCodingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReverseArrayList {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(30);

        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        Iterator iter2 = list.iterator();
        Collections.reverse(list);

        while(iter2.hasNext()){
            System.out.println(iter2.next());
        }


    }
}
