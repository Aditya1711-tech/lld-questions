import entities.WareHouse;
import enums.VehicleType;
import factories.VehicleFactory;
import strategies.impl.CashPaymentStrategy;

import java.util.ArrayList;
import java.util.Objects;

public class MainVehicleRentalManager {
    private static VehicleRentalManager vehicleRentalManager;

    public static void main(String[] args) {
        vehicleRentalManager = VehicleRentalManager.getVehicleRentalManagerInstance();

        WareHouse CalanguteWareHouse  = new WareHouse("Calangute Beach");
        WareHouse BagaWareHouse = new WareHouse("Baga Beach");
        vehicleRentalManager.addWareHouse(CalanguteWareHouse);
        vehicleRentalManager.addWareHouse(BagaWareHouse);

        CalanguteWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "CAR123", "car", 10000, 50000, 10)));
        BagaWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "CAR123", "car", 10000, 50000, 10)));

        CalanguteWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "BIKE123", "bike", 2000, 5000, 30)));
        BagaWareHouse.addVehicle(Objects.requireNonNull(VehicleFactory.createVehicle(VehicleType.CAR, "BIKE123", "bike", 2000, 5000, 30)));

        vehicleRentalManager.bookVehicle("CAR123", 2, 2);
        vehicleRentalManager.bookVehicle("CAR123", 5, 10);
    }
}
