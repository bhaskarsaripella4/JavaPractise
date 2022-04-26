package YeswantKanetkar.chapter1to6;

public class SiUsingCmdLineArgs {
    public static void main(String[] args){
        float p,r,si;
        int n;

        p = Float.parseFloat(args[0]); /*replace with parseFloat to solve unnecessary unboxing issue*/
        r = (Float.valueOf(args[2])).floatValue();
        n = (Integer.valueOf(args[1])).intValue();

        si = (n*r*p)/100;
        System.out.println("Simple Interest = Rs. "+si);
    }


}
