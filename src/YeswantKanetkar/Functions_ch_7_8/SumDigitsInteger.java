package YeswantKanetkar.Functions_ch_7_8;

public class SumDigitsInteger {

    public static void main(String[] args){
        int a = 98465;
//        System.out.println("enter 5 digit number");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            a = Integer.parseInt(br.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        int sum = 0;
        sum = digRec(a, sum);
        System.out.println("sum of digits = "+ sum);
    }

    static int digRec(int a, int sum){
        if(a == 0)
            return sum;

        else
            return digRec(a/10, sum+a%10);
    }
}
