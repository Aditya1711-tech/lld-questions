package controllers;

import entities.Elevator;
import entities.Floor;
import strategies.SchedulingStrategy;

import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private List<Floor> floors;
    private SchedulingStrategy schedulingStrategy;
    private int currentElevatorId;
}
