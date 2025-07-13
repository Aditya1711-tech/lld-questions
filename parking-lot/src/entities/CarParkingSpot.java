package entities;

public class CarParkingSpot extends ParkingSpot{

    public CarParkingSpot(int spotNumber) {
        super(spotNumber, "car");
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "car".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
