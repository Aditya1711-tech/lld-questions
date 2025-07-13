package entities.concreteVehicles;

import entities.Vehicle;
import enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(String identifier, String name, double rentPerDay, double depositAmount, int quantity) {
        super(identifier, name, rentPerDay, depositAmount, quantity, VehicleType.BIKE);
    }
}
