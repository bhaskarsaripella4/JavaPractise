package YeswantKanetkar.Chapter10ClassesObjects;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Complex{
    private float real,imag;

    public Complex(){}

    public Complex(float i, float j){
        real = i;
        imag = j;
    }

    public void getData() throws Exception{
        float r, i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter real and imaginary part");
        r = Float.parseFloat(br.readLine());
        i = Float.parseFloat(br.readLine());
        real = r;
        imag = i;
    }

    public void setData(float r, float i){
        real = r;
        imag = i;
    }

    public void displayData(){
        System.out.println("real= "+real);
        System.out.println("imaginary= "+imag);
    }

    public Complex addComplex(Complex y){
        Complex t;
        t = new Complex();
        t.real = real + y.real;
        t.imag = imag + y.imag;
        return t;
    }

    public Complex mulComplex(Complex y){
        Complex t;
        t = new Complex();
        t.real = real*y.real - imag*y.imag;
        t.imag = real*y.imag + imag*y.real;
        return t;
    }
}


public class ComplexNumbersProject {

    public static void main(String[] args) throws Exception{
        Complex c1,c2,c3;

        c1 = new Complex();
        c1.setData(2.0f, 2.0f);
        c2 = new Complex();
        c3 = c1.addComplex(c2);
        c3.displayData();

    }
}
