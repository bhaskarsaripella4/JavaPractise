package JavaCodingProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateCharsInString {
    public void countDup(String str) {

        Map<Character, Integer> map = new HashMap<Character,Integer>();

        char[] chars = str.toCharArray();

        for(Character ch:chars){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }

        Set<Character> keyset = map.keySet();
        keyset.stream().filter(x -> map.get(x) > 1).
                forEach(e -> System.out.println("Char "+e +" "+map.get(e)));

    }

    public static void main(String a[]){
        FindDuplicateCharsInString obj = new FindDuplicateCharsInString();
        System.out.println("String: BeginnersBook.com");
        System.out.println("-------------------------");
        obj.countDup("BeginnersBook.com");

        System.out.println("\nString: ChaitanyaSingh");
        System.out.println("-------------------------");
        obj.countDup("ChaitanyaSingh");

        System.out.println("\nString: #@$@!#$%!!%@");
        System.out.println("-------------------------");
        obj.countDup("#@$@!#$%!!%@");
    }

}


