package controller;

import entities.*;
import factories.VehicleFactory;
import strategies.PaymentStrategy;
import strategies.impl.CashPaymentStrategy;
import strategies.impl.MinuteWiseParkingFessStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotMain {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();

        parkingSpots.add(new CarParkingSpot(1));
        parkingSpots.add(new CarParkingSpot(2));
        parkingSpots.add(new TruckParkingSlot(3));
        parkingSpots.add(new TruckParkingSlot(4));

        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        Vehicle car1 = VehicleFactory.createVehicle("car", "CAR123", new MinuteWiseParkingFessStrategy(), 10.00);
        Vehicle truck1 = VehicleFactory.createVehicle("truck", "TRUCK123", new MinuteWiseParkingFessStrategy(), 30.00);

        ParkingSpot car1ParkingSpot = parkingLot.parkVehicle(car1);
        ParkingSpot truck1ParkingSpot = parkingLot.parkVehicle(truck1);

        PaymentStrategy cashPaymentStrategy = new CashPaymentStrategy();

        if(car1ParkingSpot != null){
            double fees = car1.calculateFees(60);
            boolean paymentSuccess = cashPaymentStrategy.processPayment(fees);

            if(paymentSuccess){
                parkingLot.vacateSpot(car1ParkingSpot, car1);
            }
        }

        if(truck1ParkingSpot != null){
            double fees = truck1.calculateFees(60);
            boolean paymentSuccess = cashPaymentStrategy.processPayment(fees);

            if(paymentSuccess){
                parkingLot.vacateSpot(truck1ParkingSpot, truck1);
            }
        }
    }
}
