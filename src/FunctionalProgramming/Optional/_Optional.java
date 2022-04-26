package FunctionalProgramming.Optional;

import java.util.Optional;
import java.util.function.Supplier;

public class _Optional {

    public static void main(String[] args) {
        Supplier<IllegalStateException> exception = () -> new IllegalStateException();

//        Object value = Optional.ofNullable("Hello")
//                .orElse("default value");

        Object value = Optional.ofNullable("Hello").orElseThrow(exception);
        System.out.println(value);


        Optional.ofNullable("john@gmial.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to" + email),
                        () -> {System.out.println("cannot send email");}
                );

    }
}
