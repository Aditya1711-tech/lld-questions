package observers;

import entities.Elevator;

public interface ElevatorSchedulingStrategy {
    int getNextStop(Elevator elevator);
}
