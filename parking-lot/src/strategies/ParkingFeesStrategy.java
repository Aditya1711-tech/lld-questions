package strategies;

import entities.Vehicle;

public interface ParkingFeesStrategy {
    double calculateFees(Vehicle vehicle, int durationInMinutes);
}
