package strategies.impl;

import entities.Vehicle;
import strategies.ParkingFeesStrategy;

public class MinuteWiseParkingFessStrategy implements ParkingFeesStrategy {
    @Override
    public double calculateFees(Vehicle vehicle, int durationInMinutes) {
        return vehicle.getParkingFeesPerMinute() * durationInMinutes;
    }
}
