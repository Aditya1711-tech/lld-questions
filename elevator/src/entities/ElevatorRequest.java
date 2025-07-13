package entities;

import enums.Direction;

public class ElevatorRequest {
    private int elevatorId;
    private int floorNumber;
    private boolean isExternalRequest;
    private Direction direction;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isExternalRequest() {
        return isExternalRequest;
    }

    public void setExternalRequest(boolean externalRequest) {
        isExternalRequest = externalRequest;
    }
}
