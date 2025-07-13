package entities;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {
    private String name;
    private Map<String, Vehicle> vehicleMap;

    public WareHouse(String name) {
        this.name = name;
        vehicleMap = new HashMap<>();
    }

    public void addVehicle (Vehicle vehicle){
        if(vehicleMap.containsKey(vehicle.getIdentifier())){
            Vehicle existingVehicle = vehicleMap.get(vehicle.getIdentifier());
            existingVehicle.setName(vehicle.getName());
            existingVehicle.setDepositAmount(vehicle.getDepositAmount());
            existingVehicle.setQuantity(existingVehicle.getQuantity() + vehicle.getQuantity());
            existingVehicle.setRentPerDay(vehicle.getRentPerDay());

            vehicleMap.put(vehicle.getIdentifier(), existingVehicle);

            System.out.println(vehicle.getQuantity() + " new " + vehicle.getName() +" added to warehouse of " + this.name + " now total quantity is " + existingVehicle.getQuantity() + " at warehouse of " + this.name);
        }else {
            vehicleMap.put(vehicle.getIdentifier(), vehicle);
        }
    }

    public synchronized boolean bookVehicle(String vehicleIdentifier, int numberOfVehiclesToBook) {
        if(!vehicleMap.containsKey(vehicleIdentifier)){
            System.out.println("Not enough vehicles available for vehicle identifier " + vehicleIdentifier + " at warehouse of " + this.name);
            return false;
        }

        Vehicle vehicle = vehicleMap.get(vehicleIdentifier);
        if(vehicle.getQuantity() < numberOfVehiclesToBook) {
            System.out.println("Not enough vehicles available for vehicle " + vehicle.getName());
            return false;
        }

        if(vehicle.getQuantity() == numberOfVehiclesToBook){
            System.out.println(numberOfVehiclesToBook + " " + vehicle.getName() + " booked successfully now, available quantity is " + 0 + " at warehouse of " + this.name);
            vehicleMap.remove(vehicleIdentifier);
        }
        else {
            vehicle.setQuantity(vehicle.getQuantity() - numberOfVehiclesToBook);
            vehicleMap.put(vehicleIdentifier, vehicle);
            System.out.println(numberOfVehiclesToBook + " " + vehicle.getName() + " booked successfully now, available quantity is " + vehicle.getQuantity() + " at warehouse of " + this.name);
        }
        return true;
    }

    public boolean isVehicleAvailable(String vehicleIdentifier, int numberOfVehicles) {
        Vehicle vehicleByIdentifier = getByIdentifier(vehicleIdentifier);
        return vehicleByIdentifier != null && vehicleByIdentifier.getQuantity() >= numberOfVehicles;
    }

    public Vehicle getByIdentifier (String vehicleIdentifier) {
        if(vehicleMap.containsKey(vehicleIdentifier)) return vehicleMap.get(vehicleIdentifier);
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }
}
