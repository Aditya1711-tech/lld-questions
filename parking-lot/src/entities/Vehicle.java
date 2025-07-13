package entities;

import strategies.ParkingFeesStrategy;

public abstract class Vehicle {
    private String registrationPlateNumber;
    private ParkingFeesStrategy parkingFeesStrategy;
    private double parkingFeesPerMinute;
    private String vehicleType;

    public Vehicle(String registrationPlateNumber, ParkingFeesStrategy parkingFeesStrategy, double parkingFeesPerMinute, String vehicleType) {
        this.registrationPlateNumber = registrationPlateNumber;
        this.parkingFeesStrategy = parkingFeesStrategy;
        this.parkingFeesPerMinute = parkingFeesPerMinute;
        this.vehicleType = vehicleType;
    }

    public abstract double calculateFees(int durationInMinutes);

    public String getRegistrationPlateNumber() {
        return registrationPlateNumber;
    }

    public void setRegistrationPlateNumber(String registrationPlateNumber) {
        this.registrationPlateNumber = registrationPlateNumber;
    }

    public ParkingFeesStrategy getParkingFeesStrategy() {
        return parkingFeesStrategy;
    }

    public void setParkingFeesStrategy(ParkingFeesStrategy parkingFeesStrategy) {
        this.parkingFeesStrategy = parkingFeesStrategy;
    }

    public double getParkingFeesPerMinute() {
        return parkingFeesPerMinute;
    }

    public void setParkingFeesPerMinute(double parkingFeesPerMinute) {
        this.parkingFeesPerMinute = parkingFeesPerMinute;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
