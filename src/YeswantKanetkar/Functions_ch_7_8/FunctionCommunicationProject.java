package YeswantKanetkar.Functions_ch_7_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FunctionCommunicationProject {
    public static void main(String[] args) throws Exception
    {
        int a,b,c;
        float sum;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter three numbers");
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

//        sum = calSum(a,b,c);
        sum = calSum(a, (int)calSum(25,10,4),b);
        System.out.println("sum = "+sum);
    }

    static float calSum(int x, int y, int z){

        return ((float)x + y + z);
    }

}
