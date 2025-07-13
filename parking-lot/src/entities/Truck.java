package entities;

import strategies.ParkingFeesStrategy;

public class Truck extends Vehicle{

    public Truck(String registrationPlateNumber, ParkingFeesStrategy parkingFeesStrategy, double parkingFeesPerMinute, String vehicleType) {
        super(registrationPlateNumber, parkingFeesStrategy, parkingFeesPerMinute, vehicleType);
    }

    @Override
    public double calculateFees(int durationInMinutes) {
        return getParkingFeesStrategy().calculateFees(this, durationInMinutes);
    }
}
