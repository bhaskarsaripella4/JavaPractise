package YeswantKanetkar.Functions_ch_7_8;

public class First25FibonacciSum {
    public static void main(String[] args){
        int n = 25;
        int i = 1;
        int count = 1;
        fib(i,0, --n);
    }

    static void fib(int curr, int pre, int count){ // 1,0,25
        if (count <0){
//            System.out.println(curr);
            return;
        }
        System.out.println(" "+curr);
        fib(curr+pre,curr, --count);

    }
}
