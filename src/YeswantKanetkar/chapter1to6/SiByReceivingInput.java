package YeswantKanetkar.chapter1to6;
import java.io.*;

public class SiByReceivingInput {
    public static void main(String[] args) throws Exception
    {
        float p,r,si;
        int n;

        System.out.println("enter volumens of p,n and r");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        p = Float.parseFloat(br.readLine());
        n = Integer.parseInt(br.readLine());
        r = Float.parseFloat(br.readLine());
        si = (p*n*r)/100;
        System.out.println("Simple Interest = Rs. "+si);
    }
}
