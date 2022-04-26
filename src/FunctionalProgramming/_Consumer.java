package FunctionalProgramming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "9909092");
        greetCustomer(maria);
        greetCustomerConsumer.accept(maria);

        String line = "Hi, I, like, Peace";
        String[] splitLine = line.split(",",0);
        Customer lined = new Customer(splitLine[3],"92830834");
        greetCustomerConsumer.accept(lined);

        greetCustomerConsumerV2.accept(maria,true);

    }

    // Declarative programming using Consumer
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello "+ customer.customerName+ ",thanks for registering phone number: "+customer.customerPhoneNumber);

    //BiConsumer -> customer, return a boolen
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 =
            (customer, showPhoneNumber) -> System.out.println("Hello "+ customer.customerName+",thanks for registering phone number:"+(showPhoneNumber ? customer.customerPhoneNumber: "**************"));


    static void greetCustomer(Customer customer){
        System.out.println("Hello "+ customer.customerName+ ",thanks for registering phone number: "+customer.customerPhoneNumber);


    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

}


