package YeswantKanetkar.chapter1to6;

public class ContinueDemoProject {
    public static void main(String[] args){
        int i, j;
        i=j=0;
        first: while(i++<=100){
            while(j++<=200){
                if (j==150)
                    continue first;
                else
                    System.out.println(i+" "+j);
            }
        }
    }
}
