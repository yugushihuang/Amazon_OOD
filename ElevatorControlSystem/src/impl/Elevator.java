package impl;

import impl.enums.ElevatorDirection;
import impl.enums.ElevatorStatus;
import interfaces.ElevatorFactory;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements ElevatorFactory {
    private Integer currentFloor;
    private Queue<Integer> destinationFloors;

    public Elevator(Integer currentFloor){
        this.currentFloor = currentFloor;
        this.destinationFloors = new LinkedList<Integer>();
    }

    public int nextDestination(){
        return this.destinationFloors.peek();
    }

    public int currentFloor(){
        return this.currentFloor;
    }

    public void popDestination(){
        this.destinationFloors.remove();
    }

    public void moveUp(){
        currentFloor++;
    }

    public void moveDown(){
        currentFloor--;
    }

    public void addNewDestination(Integer destination){
        this.destinationFloors.add(destination);
    }

    public ElevatorDirection direction(){
        if(destinationFloors.size()>0){
            if(currentFloor<destinationFloors.peek()){
                return ElevatorDirection.ELEVATOR_UP;
            }else if(currentFloor>destinationFloors.peek()){
                return ElevatorDirection.ELEVATOR_DOWN;
            }
        }

        return ElevatorDirection.ELEVATOR_HOLD;
    }

    public ElevatorStatus status() {
        return (destinationFloors.size()>0)?ElevatorStatus.ELEVATOR_OCCUPIED  : ElevatorStatus.ELEVATOR_EMPTY;
    }
}
