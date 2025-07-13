package observers.impl;

import entities.Elevator;
import enums.ElevatorState;
import observers.ElevatorObserver;

public class ElevatorScreenObserver implements ElevatorObserver {
    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState state) {
        System.out.println("Elevator " + elevator.getId() + " state changed to " + state);
    }

    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        System.out.println("Elevator " + elevator.getId() + " moved to floor " + floor);
    }
}
