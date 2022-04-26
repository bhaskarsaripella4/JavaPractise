package FunctionalProgramming.Imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        // find how many females we have usign imperative vs functional paradigms
        // Imperative approach. Uses loops, etc..
        System.out.println("Using Imperative paradigm");
        ArrayList<Person> females = new ArrayList<>();

        for(Person person: people){
//            if(person.gender == Gender.FEMALE){
            if(Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for(Person person: females){
            System.out.println(person);
        }

        // Declarative approach (functional programming)
        System.out.println("Using functional programming");
        // can use streams and collections
        List<Person> femalesList = people.stream().
                filter(person -> person.gender.equals(Gender.FEMALE)).
                collect(Collectors.toList());
//                forEach(femalesList::add);
        femalesList.forEach(System.out::println);
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
