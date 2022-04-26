package YeswantKanetkar.Ch12StringsEnum;

public class SortingStringsProject {
    public static void main(String[] args)throws Exception{
        String[] names = new String[]{"Akshay","Parag","Raman","Srinivas","Gopal","Rajesh"};
        int i,j, result;
        String temp;

        for(i=0;i<= names.length-1;i++){
            for(j=0;j<=names.length-1;j++){
                result = names[i].compareTo(names[j]);
                if(result>0){
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        for(String n: names) System.out.println(n);
    }
}
