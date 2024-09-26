package temp;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ConcurrentModificationWithStreamsExample {

    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            numbers.add(i);
        }

        ExecutorService executors = Executors.newFixedThreadPool(2);

        // add number to list using a thread
        executors.submit(() -> {
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            numbers.add(10);
            System.out.println("Added 10 to list");
        });

        // use streams to process the list
        executors.submit(() -> {
            numbers.stream().forEach( num -> System.out.println("Number processed: "+num) );
            try{
                Thread.sleep(50); // simulate some processign time
            }catch (InterruptedException e1){
                Thread.currentThread().interrupt();
            }
        });

        executors.shutdown();


        List<Integer> numbers1 = IntStream.range(1,1000).boxed().collect(Collectors.toList());

        //process using parallel stream
        int result = numbers1.parallelStream().mapToInt(Integer::intValue).sum();

        System.out.println("sum of all integers via parallel stream: "+result);
    }
}
