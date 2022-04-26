package DesignPatterns.Factory;

import java.util.function.Function;

/* Factory method gives client an interface for which an instance can be created.
Hides the implementation details on how to create objects
https://theboreddev.com/functional-patterns-in-java/
 */
//enum VehicleType {
//    BUS,
//    CAR,
//    TRUCK
//}


// conventional way of implementing Factory
//public class Vehicle instanceOfType(VehicleType type, VehicleColor color){
//    // can implement using if clauses, switch or Java Enum.
//
//        if(type.equals(VehicleType.CAR)){
//            return new Car(color);
//        }// repeat for Bus, Truck.
//        throw new IllegalArugumentException("No Support for type"+type);
//}

//Functional programming way of implementing factory
public enum VehicleType{
    BUS(Bus::new),
    TRUCK(Truck::new),
    CAR(Car::new);

    public final Function<VehicleColor, Vehicle> factory;
        // This function needs definition

    // constructor taking function as input
    VehicleType(Function<VehicleColor, Vehicle> factory){
        this.factory = factory;
    }
}



public class FactoryMethodEx1 {
}
