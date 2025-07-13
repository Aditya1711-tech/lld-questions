package entities;

import enums.VehicleType;

public class Vehicle {
    private String identifier;
    private String name;
    private double rentPerDay;
    private double depositAmount;
    private int quantity;
    private VehicleType vehicleType;

    public Vehicle(String identifier, String name, double rentPerDay, double depositAmount, int quantity, VehicleType vehicleType) {
        this.identifier = identifier;
        this.name = name;
        this.rentPerDay = rentPerDay;
        this.depositAmount = depositAmount;
        this.quantity = quantity;
        this.vehicleType = vehicleType;
    }

    public double getAmountToPay(Vehicle vehicle, int numberOfDays, int numberOfVehicles) {
        return ((numberOfDays * vehicle.getRentPerDay()) + vehicle.getDepositAmount()) * numberOfVehicles;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
