package JavaCodingProblems;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class FindPalindromeUsingStackQueue {

    public static void main(String[] args) {
        System.out.println("Enter String");
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        Stack stack = new Stack();

        char[] chars = inputString.toCharArray();

        // stack is LIFO
        for(int i = 0; i < chars.length; i++){
            stack.push(chars[i]);
        }


        // Queue is FIFO
        Queue queue = new LinkedList();
        for(int i = 0; i< chars.length; i++){
            queue.add(chars[i]);
        }

        String reverseStringQueue = "";
        while(!queue.isEmpty()){
            reverseStringQueue = reverseStringQueue+queue.remove();
        }

        String reverseString = "";
        while(!stack.isEmpty()){
            reverseString = reverseString+stack.pop();
        }

        System.out.println(reverseString);

        if(inputString.equals(reverseStringQueue)){
            System.out.println("String is a palindrome");
        }else {
            System.out.println("Not a palindrome");
        }


    }







}
