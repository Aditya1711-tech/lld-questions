package entities;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findEmptyParkingSpot(String vehicleType){
        for (ParkingSpot parkingSpot : parkingSpots) {
            if(!parkingSpot.isOccupied() && parkingSpot.getSpotType().equalsIgnoreCase(vehicleType)){
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle (Vehicle vehicle){
        ParkingSpot parkingSpot = findEmptyParkingSpot(vehicle.getVehicleType());
        if(parkingSpot != null){
            parkingSpot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully on parking spot with number: " + parkingSpot.getSpotNumber());
            return parkingSpot;
        }
        System.out.println("No parking spot available for vehicle type: " + vehicle.getVehicleType());
        return null;
    }

    public void vacateSpot(ParkingSpot spot, Vehicle vehicle) {
        if (spot != null && spot.isOccupied()
                && spot.getVehicle().equals(vehicle)) {
            spot.vacate();
            System.out.println(vehicle.getVehicleType()
                    + " vacated the spot: " + spot.getSpotNumber());
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant "
                    + "or the vehicle does not match.");
        }
    }

    public ParkingSpot findParkingSpotById(int parkingSpotId){
        for (ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.getSpotNumber() == parkingSpotId){
                return parkingSpot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
