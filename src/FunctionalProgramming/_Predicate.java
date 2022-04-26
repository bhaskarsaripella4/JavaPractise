package FunctionalProgramming;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700789000"));
        System.out.println(isPhoneNumberValid("09000789000"));

        System.out.println("Using Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700789000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000789000"));

        //chaining predicates
        System.out.println("Is phone number valid and contains 3? "+isPhoneNumberValidPredicate.and(containsNumber3).test("07000000000"));
        System.out.println("Is phone number valid or contains 3? "+isPhoneNumberValidPredicate.or(containsNumber3).test("0700789000"));
        System.out.println("Is phone number valid and contains 3? "+isPhoneNumberValidPredicate.and(containsNumber3).test("09000789000"));

    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    // repeat above function using Predicate
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07")
            && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
