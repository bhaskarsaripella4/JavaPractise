package DesignPatterns.SOLID;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
* */
enum Relationship{
    PARENT, CHILD, SIBLING
}

class Triplet<T,U,V>{
    private final T Value0;
    private final U Value1;
    private final V Value2;

    Triplet(T first, U second, V third) {
        this.Value0 = first;
        this.Value1 = second;
        this.Value2 = third;
    }

    public T getValue0() { return Value0;}
    public U getValue1() { return Value1;}
    public V getValue2() { return Value2;}
}

class Person{
    public String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/* create an interface to enable DIP */
interface RelationshipBrowser{
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser{ // single responsibility is conserved here. Only relation list is modified.
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
    /* to expose a private member, you need a public getter. But exposing a public member
    * of a low-level class like Relationships (low level class directly interface with data storage
    * hence need dependency injection*/


    public void addParentAndChild(Person parent, Person child){
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    /*Implement the interface methods here for DIP */
    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream().filter(x -> Objects.equals(x.getValue0().name, name)
                        && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }

}

class Research{
//    public Research(Relationships relationships){
//        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//
//        relations.stream().filter(x -> x.getValue0().name.equals("John")
//                && x.getValue1().equals(Relationship.PARENT))
//                .forEach(ch -> System.out.println("John has a child called "+ch.getValue2().name));
//    }

    public Research(RelationshipBrowser browser){
        List<Person> children = browser.findAllChildrenOf("John");
        for(Person child: children){
            System.out.println("John has a child called "+child.name);
        }
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent,child1);
        relationships.addParentAndChild(parent,child2);

        Research research = new Research(relationships);


    }




}
