package DesignPatterns.SOLID;

import java.util.List;
import java.util.stream.Stream;

/* This pattern is called Pattern of enterprise engineering or specification
* Say you want to filter products on a criteria on a website say amazon */
enum Color{
    RED,GREEN,BLUE
}

enum Size{
    SMALL, MEDIUM, LARGE, HUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size){
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter{
    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter(p -> p.color == color);
    }
    /* this below is a copy of the previous function.
    * Instead this method or class instead of modification can be extended and
    * a new method listed. This is Open closed principle.
    *  Closed for modification, open for extension */
    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter(p -> p.size == size);
    }
    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color){
        return products.stream().filter(p -> p.size == size && p.color == color);
    }

}

/* IMplementing OCP using interfaces */
interface Specification<T>{
    boolean isSatisfied(T item);
}

//interface AddSpecification<T>{
//    private Specification<T> first,second;
//}

interface Filter<T>{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{
    private Color color;

    public ColorSpecification(Color color){
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item){
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product>{
    private Size size;

    public SizeSpecification(Size size){
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item){
        return item.size == size;
    }
}

class AndSpecification<T> implements Specification<T>{

    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second){
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class BetterFilter implements  Filter<Product>{
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

public class OCP {

    public static void main(String[] args) {
        Product clothes = new Product("Clothes",Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree",Color.GREEN, Size.HUGE);
        Product car = new Product("Car",Color.BLUE, Size.LARGE);

        List<Product> products = List.of(clothes, tree, car);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products (old):");
        pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - "+ p.name +" is green"));

        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (new):");
        bf.filter(products, new ColorSpecification(Color.GREEN)).forEach(p -> System.out.println(" - "+p.name+" is green"));

        bf.filter(products, new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE)))
                .forEach(p -> System.out.println(" - "+p.name+" is both blue and large"));
    }

}
