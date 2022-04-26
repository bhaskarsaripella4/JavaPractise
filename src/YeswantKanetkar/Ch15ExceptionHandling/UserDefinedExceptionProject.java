package YeswantKanetkar.Ch15ExceptionHandling;

class Customer{
    private String name;
    private int accno;
    private float balance;

    public Customer(String n, int a, float b){
        name = n; accno = a; balance = b;
    }

    public float withdraw(int amt) throws BankException{
        if(balance - amt <=500){
            throw new BankException(accno, balance);
        }

        balance -= amt;
        return balance;
    }
}

class BankException extends Exception{
    private int acc;
    private float bal;

    public BankException(int a, float b){
        this.acc = a; this.bal = b;
    }

    public void inform(){
        System.out.println("Acc No: "+acc);
        System.out.println("Balance: "+bal);
    }
}

public class UserDefinedExceptionProject {
    public static void main(String[] args){
        try{
            Customer c = new Customer("Rayul",2345, 1000);
            float balance = c.withdraw(700);
            System.out.println("Balance: "+balance);

        }
        catch(BankException e){
            System.out.println("Transaction failed");
            e.inform();
        }
    }
}
