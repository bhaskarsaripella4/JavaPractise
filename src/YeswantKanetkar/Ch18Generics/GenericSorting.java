package YeswantKanetkar.Ch18Generics;

public class GenericSorting {
    public static void main(String[] args){
        Float num[] = {5.4f, 3.23f, 2.15f, 1.09f, 24.55f};
        Integer arr[] = {-12,23,14,0,15,14,38,3};
        int i;

        sort(num, 5);
        for(i = 0;i<=4;i++) System.out.print(num[i]+" ");
        System.out.println();

        sort(arr, 8);
        for(i = 0; i<=7;i++) System.out.print(arr[i]+" ");
    }

    public static <T extends Comparable <T>> void sort(T[] n,int size){
        int i,j;
        T t;

        for(i = 0; i<=size;i++){
            for(j = i+1;j<=size-1;j++){
                if(n[i].compareTo(n[j])>0){
                    t = n[i];
                    n[i] = n[j];
                    n[j] = t;
                }
            }
        }
    }
}
