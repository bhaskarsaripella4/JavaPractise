package YeswantKanetkar.Ch18Generics;

public class GenericFunction {
    public static <T> void printArray(T[] arr){
        for(T i:arr) System.out.printf("%s",i);
        System.out.println();
    }

    public static void main(String args[]){
        Integer[] intarr = {10,-2,37,42,15};
        Float[] floatarr = {3.14f, 6.28f, -1.5f, -3.44f, 7.234f};

        printArray(intarr);
        printArray(floatarr);
    }
}
