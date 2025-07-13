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
    private static List<WareHouse> wareHouses;
    private static PaymentStrategy paymentStrategy;

    private static boolean bookVehicle(String vehicleIdentifier, int numberOfDays, int numberOfVehicles) {
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

    public static void main(String[] args) {
        wareHouses = new ArrayList<>();
        paymentStrategy = new CashPaymentStrategy();

        WareHouse CalanguteWareHouse  = new WareHouse("Calangute Beach");
        WareHouse BagaWareHouse = new WareHouse("Baga Beach");
        wareHouses.add(CalanguteWareHouse);
        wareHouses.add(BagaWareHouse);

        CalanguteWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "CAR123", "car", 10000, 50000, 10)));
        BagaWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "CAR123", "car", 10000, 50000, 10)));

        CalanguteWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "BIKE123", "bike", 2000, 5000, 30)));
        BagaWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "BIKE123", "bike", 2000, 5000, 30)));

        bookVehicle("CAR123", 2, 2);
        bookVehicle("CAR123", 5, 10);
    }
}
