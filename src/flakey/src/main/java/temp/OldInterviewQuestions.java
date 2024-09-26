package temp;

import java.util.*;
import java.util.stream.*;

public class OldInterviewQuestions {

    public static Integer maxProfit(int[] prices){
        int maxprofit = 0;

        for (int i=1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                maxprofit += prices[i] - prices[i-1];
            }
        }
        return maxprofit;
    }

    public static List<Integer> convertions(int[] arr){
        return Arrays.stream(arr).sorted().mapToObj(i -> (Integer)i).collect(Collectors.toList());
    }


    public static void main(String[] args){

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices2)); // Output: 4

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices3)); // Output: 0

        System.out.println(convertions(prices3));
    }
}
