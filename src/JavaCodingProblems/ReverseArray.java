package JavaCodingProblems;

import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseArray {

    public static void main(String[] args) {

        String word = "283208usdfas09-2";

        char[] array = word.toCharArray();

        Stack stack = new Stack<>();

        for(int i = 0; i < array.length; i++){
            stack.push(array[i]);
        }

        // to reverse
        String reversedArray = "";
        int i=0;
        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
            array[i] = (char) stack.pop();
            i+=1;
        }

        System.out.println(array);

    }
}
