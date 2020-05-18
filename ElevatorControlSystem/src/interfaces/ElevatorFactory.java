package interfaces;

import impl.enums.ElevatorDirection;
import impl.enums.ElevatorStatus;

public interface ElevatorFactory {
    public void moveUp();
    public void moveDown();
    public void addNewDestination(Integer destination);
    public ElevatorDirection direction();
    public ElevatorStatus status();
}
