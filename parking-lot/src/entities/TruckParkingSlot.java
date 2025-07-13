package entities;

public class TruckParkingSlot extends ParkingSpot{

    public TruckParkingSlot(int spotNumber) {
        super(spotNumber, "truck");
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "truck".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
