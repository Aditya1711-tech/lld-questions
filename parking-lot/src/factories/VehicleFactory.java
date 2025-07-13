package factories;

import entities.Car;
import entities.Other;
import entities.Truck;
import entities.Vehicle;
import strategies.ParkingFeesStrategy;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String registrationPlateNumber, ParkingFeesStrategy parkingFeesStrategy, double parkingFeesPerMinute){
        if("car".equalsIgnoreCase(vehicleType)) {
            return new Car(registrationPlateNumber, parkingFeesStrategy, parkingFeesPerMinute, "car");
        }else if("truck".equalsIgnoreCase(vehicleType)){
            return new Truck(registrationPlateNumber, parkingFeesStrategy, parkingFeesPerMinute, "truck");
        }
        return new Other(registrationPlateNumber, parkingFeesStrategy, parkingFeesPerMinute, "other");
    }
}
