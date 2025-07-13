package entities.concreteVehicles;

import entities.Vehicle;
import enums.CarType;
import enums.VehicleType;

public class Car extends Vehicle {
    private CarType carType;

    public Car(String identifier, String name, double rentPerDay, double depositAmount, int quantity) {
        super(identifier, name, rentPerDay, depositAmount, quantity, VehicleType.CAR);
        this.carType = CarType.FOUR_SEATER;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
