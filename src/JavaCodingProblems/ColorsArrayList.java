package JavaCodingProblems;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ColorsArrayList {

    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Black");
        colors.add("Orange");

        colors.ensureCapacity(10); // only works for ArrayList etc not for Lists

        System.out.println("ArrayList after creation");
        for(String color: colors){
            System.out.println(color);
        }

        List<String> nameList = new ArrayList<>();
        List<String> namesList = Arrays.asList("Safhin","sodun","dasufh","eiouowehh","diuosahfio");
        nameList.addAll(namesList);

        for(String name: nameList){

//            nameList.remove(2); // this gives error. Modifying a list while iterating
            System.out.println(name);
        }

        //alternate method is using iterator
        Iterator<String> nameListIterator = nameList.iterator();
        while(nameListIterator.hasNext()){
            String currentName = nameListIterator.next();
            if(currentName.equals("sodun")){
                nameListIterator.remove();
            }
        }
        System.out.println("After Deleting name");
        for(String name: nameList){
            System.out.println(name);
        }


            // delete 3rd element
//        colors.remove(2);

        // sort collection
//        Collections.sort(colors);


        List<String> colorsCopy = new ArrayList<>();//
//        Collections.copy(colorsCopy,colors);// these two lines throw IndexoutofBounds error as capacity and size are different. size set does not ensure arraylist has capacity to store.It is still empty
        // hence instead use addAll
        colorsCopy.addAll(colors);
        // or using streams
        List<String> colorsCopy2 = colors.stream().collect(Collectors.toList());
        for(String color: colorsCopy2){
            System.out.println(color);
        }
    }
}
