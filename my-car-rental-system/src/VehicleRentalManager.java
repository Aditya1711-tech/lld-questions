import entities.Vehicle;
import entities.WareHouse;
import enums.VehicleType;
import factories.VehicleFactory;
import strategies.PaymentStrategy;
import strategies.impl.CashPaymentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleRentalManager {
    private static VehicleRentalManager vehicleRentalManagerInstance;
    private List<WareHouse> wareHouses;
    private PaymentStrategy paymentStrategy;

    private VehicleRentalManager() {
        this.wareHouses = new ArrayList<>();
        this.paymentStrategy = new CashPaymentStrategy();
    }

    public boolean bookVehicle(String vehicleIdentifier, int numberOfDays, int numberOfVehicles) {
        for (WareHouse wareHouse : wareHouses) {
            if(wareHouse.isVehicleAvailable(vehicleIdentifier, numberOfVehicles)) {
                Vehicle vehicle = wareHouse.getByIdentifier(vehicleIdentifier);
                double amountToPay = vehicle.getAmountToPay(vehicle, numberOfDays, numberOfVehicles);

                boolean isPaymentSuccess = paymentStrategy.processPayment(amountToPay);
                if (isPaymentSuccess) return wareHouse.bookVehicle(vehicle.getIdentifier(), numberOfVehicles);
            }
        }

        return false;
    }

    public static synchronized VehicleRentalManager getVehicleRentalManagerInstance() {
        if(vehicleRentalManagerInstance == null) {
            vehicleRentalManagerInstance = new VehicleRentalManager();
        }
        return vehicleRentalManagerInstance;
    }

    public void addWareHouse(WareHouse wareHouse){
        wareHouses.add(wareHouse);
    }

    public List<WareHouse> getWareHouses() {
        return wareHouses;
    }

    public void setWareHouses(List<WareHouse> wareHouses) {
        this.wareHouses = wareHouses;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
