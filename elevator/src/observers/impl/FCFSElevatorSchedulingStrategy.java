package observers.impl;

import entities.Elevator;
import observers.ElevatorSchedulingStrategy;

public class FCFSElevatorSchedulingStrategy implements ElevatorSchedulingStrategy {
    @Override
    public int getNextStop(Elevator elevator) {
        return 0;
    }
}
