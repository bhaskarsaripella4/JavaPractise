package temp;


import java.util.*;

public class leetcode1 {
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();

//        Integer[] list = {1,2,3,1};
//        Integer[] list = {1,2,3,4};
        Integer[] list = {1,1,1,3,3,4,3,2,4,2};

        System.out.println("result:" + containsDuplicate(list,mySet));


    }


    public static boolean containsDuplicate(Integer[] list, Set<Integer> set){
        for(int i = 0; i< list.length; i++){
            if(set.contains(list[i])){
                return true;
            }
            else set.add(list[i]);
        }
        return false;
    }
}
