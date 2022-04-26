package JavaCodingProblems;

import java.util.Iterator;
import java.util.TreeSet;

public class ColorsTreeSet {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("Green");
        treeSet.add("Blue");
        treeSet.add("Black");
        treeSet.add("Yellow");
        treeSet.add("White");
        treeSet.add("Pink");

        Iterator<String> treeIterator = treeSet.iterator();
        System.out.println("printing first and last using iterator");
        System.out.println(treeIterator.next());
        while(treeIterator.hasNext()){
//            System.out.println(treeIterator.next());
            Object current = treeIterator.next();
            if(!(treeIterator.hasNext())){
                System.out.println(current);
            }
        }
        System.out.println("printing first and last elements using treeset methods");
//        System.out.println((Object) treeSet.first());
//        System.out.println((Object) treeSet.last());
    }
}
