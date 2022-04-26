package YeswantKanetkar.Ch18Generics;

public class MinUsingGenerics {
    public static <T extends Comparable <T>>T minimum(T a, T b){
        if(a.compareTo(b)<0) return a;
        else return b;
    }

    public static void main(String[] args){
        Character ch='A', dh='Z',eh;
        eh = minimum(ch,dh);
        System.out.println(eh);
    }
}
