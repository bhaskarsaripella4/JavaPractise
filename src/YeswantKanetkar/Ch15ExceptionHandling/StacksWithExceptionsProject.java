package YeswantKanetkar.Ch15ExceptionHandling;

class Stack{
    private int capacity;
    private int size;
    private Object[] data;

    public Stack(int cap){
        this.capacity = cap;
        data = new Object[cap];
        size = 0;
    }

    public void push(Object o) throws StackException{
        if(size == capacity) throw new StackException("Stack FUll");

        data[size] = o;
        size++;
    }

    public Object pop() throws StackException{
        if (size <= 0) throw new StackException("Stack is empty");

        size--;
        return data[size];
    }

    public int getSize(){
        return size;
    }
}

class StackException extends Exception{
    private String errormsg;

    public StackException(String s){
        this.errormsg = s;
    }

    public void inform(){
        System.out.println(errormsg);
    }
}

public class StacksWithExceptionsProject {
    public static void main(String[] args){
        Stack s = new Stack(3);
        try{
            s.push("Rahul");
            s.push("Vindo");
            s.push(25);
            s.push(3.14f);
        }
        catch(StackException ex){
            System.out.println("Problem in stack");
            ex.inform();
        }

        try{
            while(s.getSize()>0){
                System.out.println(s.pop());
            }
        }
        catch(StackException ex){
            System.out.println("Problem in stack");
            ex.inform();
        }
    }
}
