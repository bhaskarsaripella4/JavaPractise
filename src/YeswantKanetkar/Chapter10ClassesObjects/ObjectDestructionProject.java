package YeswantKanetkar.Chapter10ClassesObjects;

class Example{
    private int data;
    public Example(){
        System.out.println("Instide the `constructor");
    }

    protected void finalize() throws Throwable{
        super.finalize();
    }
}

public class ObjectDestructionProject {

    public static void main(String[] args)
    {
        Example e = new Example();
    }
}
