package temp;

import java.util.*;
import java.util.stream.*;

public class DuplicateCharInListString {

    public static Map<Character, Integer> findDup(String s){

//        List<String> charMap = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
//        .entrySet().stream().filter(cha -> cha.getValue()>1).map(in -> in.getKey()).collect(Collectors.toList());
        Map<Character, Integer> charMap = new HashMap<>();

        String[] s1 = s.split(" ");
        Arrays.stream(s1).forEach(System.out::println);
        for(String s2: s1){
            for(Character c: s2.toCharArray()){
                System.out.println(c);
                int count = charMap.getOrDefault(c,0);
                charMap.put(c,count+1);
            }
        }
        System.out.println(charMap.entrySet());
        return charMap;
    }



    public static void main(String[] args) {

        String s = "This is prep for interview";

        Map<Character,Integer> charMapFinal = findDup(s);
        charMapFinal.forEach((chars,count) -> System.out.println("chars: "+chars+" count: "+count));

    }
}
