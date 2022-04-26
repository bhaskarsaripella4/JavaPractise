package Streams;

import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class streamsTutorial {

    public Stream<String> streamOf (List < String > list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    public static void main(String[] args) {

        Stream<Object> streamEmpty = Stream.empty().parallel(); // Object uses .parallel()

        LinkedList<String> LList = new LinkedList<>();

        Stream<String> seqStreamEmpty = LList.parallelStream(); // Collections can use .parallelStream()

        Stream<String> stringStreamSequential = seqStreamEmpty.sequential(); // revert parallel to seq stream
        boolean isParallel = stringStreamSequential.isParallel();



        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamArr = Arrays.stream(arr);
        // also can do a part of array
        Stream<String> streamArrPart = Arrays.stream(arr, 0, 3);

        //Stream Builder
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        // Generate method. mention limit else will run until memory limit
        Stream<String> streamGenerator = Stream.generate(() -> "element").limit(10); // 10 strings with value element created

        // Using iterate method
        Stream<Integer> streamIterator = Stream.iterate(40, n -> n + 2).limit(10);

        //Stream of string
        Stream<String> streamOfString = Pattern.compile(",").splitAsStream("a,b,c");
        streamOfString.forEach(s -> System.out.print(s+"\n"));
    }

}
