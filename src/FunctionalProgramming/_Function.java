package FunctionalProgramming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
//        System.out.println(increment(1));
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Function<Integer, Integer> addBy1andThenMultiply2 = incrementByOneFunction.andThen(multipleByTenFunction);
        System.out.println(addBy1andThenMultiply2.apply(3));

        // BiFucntion
        System.out.println(incrementByOneAndMultiply.apply(4,100));

    }

    // Using Function<T,R> from function package in java i.e. java.util.function
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer,Integer> multipleByTenFunction =
            number -> number*10;

    // combine both the above functions using BiFucntion
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply =
            (number1, number2) -> (number1 + 1)*number2;


    // conventional way of using function
//    static int increment(int num){
//        return num + 1;
//    }



}
