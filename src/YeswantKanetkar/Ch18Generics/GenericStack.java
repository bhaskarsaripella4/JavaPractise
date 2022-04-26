package YeswantKanetkar.Ch18Generics;

class Stack <T>{
    private T arr[];
    private int top;
    private int size;

    Stack(int size){
        this.size = size;
        top = -1;
        arr = (T[]) new Object[this.size];
    }

    boolean isFull(){
        if(top==this.size) return true;
        else return false;
    }

    void push(T data){
        top++;
        arr[top] = data;
    }

    boolean isEmpty(){
        if(top==1) return true;
        else return false;
    }

    T pop(){
        T val;
        val = arr[top];
        top--;
        return val;
    }
}

class Complex{
    float r,i;

    public Complex(float rr, float ii){
        r = rr;
        i = ii;
    }

    public void printData(){
        System.out.println("Real+"+r+"Imag="+i);
    }
}

public class GenericStack {
    public static void main(String[] args){
        Stack <Integer> s1;
        s1 = new Stack<Integer>(10);

        if(!s1.isFull()) s1.push(10);
        if(!s1.isFull()) s1.push(20);
        if(!s1.isFull()) s1.push(30);

        int data1;
        if(!s1.isEmpty()){
            data1 = s1.pop();
            System.out.println(data1);
        }

    }
}
