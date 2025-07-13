package factories;

import entities.Vehicle;
import entities.concreteVehicles.Bike;
import entities.concreteVehicles.Car;
import enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String identifier, String name, double rentPerDay, double depositAmount, int quantity) {
        if(VehicleType.CAR.equals(vehicleType)){
            return new Car(identifier, name, rentPerDay, depositAmount, quantity);
        }else if(VehicleType.BIKE.equals(vehicleType)){
            return new Bike(identifier, name, rentPerDay, depositAmount, quantity);
        }
        return null;
    }
}
