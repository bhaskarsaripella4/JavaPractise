package YeswantKanetkar.Chapter10ClassesObjects;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Number{
    private int i;

    public void setData(int j){
        i = j;
    }

    public void getData() throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any integer");
        i = Integer.parseInt(br.readLine());
    }

    public Number(){}

    public Number(int j){i = j;}

    public void displayData(){
        System.out.println("value of i = "+i);
    }
}


public class ConstructorsProject {

    public static void main(String[] args) throws Exception
    {
        Number n1, n2, n3;

        n1 = new Number();
        n1.displayData();
        n1.setData(200);
        n1.displayData();

        n2 = new Number();
        n2.getData();
        n2.displayData();

        n3 = new Number(100);
        n3.displayData();
    }


}
