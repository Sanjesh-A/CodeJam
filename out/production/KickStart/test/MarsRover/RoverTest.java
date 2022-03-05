package MarsRover;

import org.junit.jupiter.api.Test;

import static MarsRover.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    @Test
    public void testTurnLeft(){
        Rover rover = new RoverBuilder().setX(5).setY(5).setDirection(North).createRover();
        rover.turnLeft();
        assertEquals(West, rover.getDirection());
        assertEquals(5, rover.getLocation().getX());
        assertEquals(5, rover.getLocation().getY());
    }

    @Test
    public void testTurnRight(){
        Rover rover = new RoverBuilder().setX(5).setY(5).setDirection(North).createRover();
        rover.turnRight();
        assertEquals(East, rover.getDirection());
        assertEquals(5, rover.getLocation().getX());
        assertEquals(5, rover.getLocation().getY());
    }


}