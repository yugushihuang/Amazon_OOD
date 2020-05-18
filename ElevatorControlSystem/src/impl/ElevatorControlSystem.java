package impl;

import impl.enums.ElevatorDirection;
import impl.exceptions.InvalidNumber;
import interfaces.ElevatorControlSystemFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// The Elevator control system manages all of the elevators and process the next tick of the system.
// It is responsible for handling pickup requests which come from people outside of the elevator
// and destination requests which come from users inside the elevator

public class ElevatorControlSystem implements ElevatorControlSystemFactory {
    public static final int MAX_ELEVATORS = 16;
    Integer numberOfElevators = 0;
    Integer numberOfFloors = 0;
    ArrayList<Elevator> elevators;
    Queue<Integer> pickupLocations;

    public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors) throws InvalidNumber {
        if(numberOfElevators<0) throw new InvalidNumber("Elevator number must be positive");

        this.numberOfElevators = (numberOfElevators > MAX_ELEVATORS)? MAX_ELEVATORS:numberOfElevators;
        this.numberOfFloors = numberOfFloors;

        initializeElevators();

        pickupLocations = new LinkedList<Integer>();

    }

    private void initializeElevators(){
        elevators = new ArrayList<Elevator>();
        for(int idx=0;idx<this.numberOfElevators;idx++){
            elevators.add(new Elevator(1));
        }
    }

    public void pickUp(Integer pickUpFloor){
        pickupLocations.add(pickUpFloor);
    }

    public void destination(Integer elevatorId, Integer destinationFloor){
        elevators.get(elevatorId).addNewDestination(destinationFloor);
    }

    public void step(){
        for(Elevator currElevator: elevators){
            switch (currElevator.status()){
                case ELEVATOR_EMPTY:
                    if(!pickupLocations.isEmpty())
                        currElevator.addNewDestination(pickupLocations.poll());
                    break;
                case ELEVATOR_OCCUPIED:
                    switch (currElevator.direction()){
                        case ELEVATOR_UP:
                            currElevator.moveUp();
                            break;
                        case ELEVATOR_DOWN:
                            currElevator.moveDown();
                            break;
                        case ELEVATOR_HOLD:
                            currElevator.popDestination();
                            break;
                    }
                    if(currElevator.direction()== ElevatorDirection.ELEVATOR_UP)
                        break;
            }
        }
    }
}
