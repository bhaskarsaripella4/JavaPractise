package YeswantKanetkar.Functions_ch_7_8;

public class FormalArgChangeProject {
    public static void main(String[] args){
        int a= 30;
         fun(a);
         System.out.println(a);
    }

    static void fun(int b){
        b = 60;
        System.out.println(b);
    }
}
