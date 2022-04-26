package JavaCodingProblems;

import java.net.SocketTimeoutException;
import java.util.Stack;
import java.lang.Math;

public class ReverseNumberRecursion {

    public static void reverse(Integer number, Stack stack){

        if(number <10){
            stack.push(number);
        }else {
            stack.push(number % 10);
            reverse(number / 10, stack);
        }
    }

    public static void main(String[] args) {
        int num = 0;
        num = 449815;
        Stack stack = new Stack();
        reverse(num, stack);
        int revNum = 0;
        int i =0;
        while(!stack.isEmpty()){
            revNum = (int) (revNum + ((int)(stack.pop()))*(Math.pow(10,i)));
            i+=1;
        }

        System.out.println("reverse of the number is "+revNum);
    }
}



