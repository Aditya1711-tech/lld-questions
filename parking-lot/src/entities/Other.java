package entities;

import strategies.ParkingFeesStrategy;

public class Other extends Vehicle{


    public Other(String registrationPlateNumber, ParkingFeesStrategy parkingFeesStrategy, double parkingFeesPerMinute, String vehicleType) {
        super(registrationPlateNumber, parkingFeesStrategy, parkingFeesPerMinute, vehicleType);
    }

    @Override
    public double calculateFees(int durationInMinutes) {
        return getParkingFeesStrategy().calculateFees(this, durationInMinutes);
    }
}
