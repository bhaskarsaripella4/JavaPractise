package YeswantKanetkar.Functions_ch_7_8;

public class VarArgsProject {
    public static void main(String args[])
    {
        double d1 = 10.0; double d2 = 20.0;
        double d3 = 30.0; double d4 = 40.0;

        System.out.printf("Avg = %f\n", average(d1, d2));
        System.out.printf("Avg = %f\n", average(d1, d2,d3));
        System.out.printf("Avg = %f\n", average(d1, d2, d4, d3));
    }

    static double average(double... numbers){
        double avg = 0;
        for(double d: numbers){
            avg = avg + d;
        }

        return avg/ numbers.length;
    }
}
