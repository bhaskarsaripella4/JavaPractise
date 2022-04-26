package FunctionalProgramming;


/* represents a supplier of results*/

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        // Supplier
        System.out.println(getDBConnectionUrlsSupplier.get());

    }

    static String getDBConnectionUrl(){
        return "jdbc://localhost:4532/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:4532/users";


     static Supplier<List<String>> getDBConnectionUrlsSupplier = () -> List.of("jdbc://localhost:4532/users",
        "jdbc://localhost:4532/customer");
}
