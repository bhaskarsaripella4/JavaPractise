package FunctionalProgramming.streams;

import FunctionalProgramming.Imperative.Main;


import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

//        Set<Gender> genders = people.stream()
//                .map(person->person.gender)
//                .collect(Collectors.toSet());
        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())
//                .collect(Collectors.toSet())
                .forEach(System.out::println); // or use method reference System.out::println


        // conventional way for the above streams is as below
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        Predicate<Person> personPredicate = person -> person.gender.equals(Gender.FEMALE);
//                people.stream()
//                .allMatch(person -> person.gender.equals(Gender.FEMALE));

        boolean allFemales = people.stream().noneMatch(personPredicate);

        System.out.println(allFemales);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString(){
            return "Person{"+"name= "+name+" gender= "+gender+" }";
        }
    }

    enum Gender{
        MALE, FEMALE;
    }
}
