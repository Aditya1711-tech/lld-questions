package entities;

import enums.Direction;
import enums.ElevatorState;
import observers.ElevatorObserver;

import java.util.List;
import java.util.Queue;

public class Elevator {

    private int id;
    private Floor currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private List<ElevatorObserver> observers;
    private Queue<ElevatorRequest> requests;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public List<ElevatorObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<ElevatorObserver> observers) {
        this.observers = observers;
    }

    public Queue<ElevatorRequest> getRequests() {
        return requests;
    }

    public void setRequests(Queue<ElevatorRequest> requests) {
        this.requests = requests;
    }
}
