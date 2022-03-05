package MarsRover;

import static MarsRover.Direction.*;

public class Rover {
    private Coordinates location;
    private Direction direction;

    public Rover(Coordinates location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public Rover(int x, int y, Direction direction) {
        this.location = new Coordinates(x,y);
        this.direction = direction;
    }

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        switch (this.direction){
            case North:
                this.direction = West;
                break;
            case East:
                this.direction = North;
                break;
            case South:
                this.direction = East;
                break;
            case West:
                this.direction = South;
                break;
        }
    }

    public void turnRight() {
        switch (this.direction){
            case North:
                this.direction = East;
                break;
            case East:
                this.direction = South;
                break;
            case South:
                this.direction = West;
                break;
            case West:
                this.direction = North;
                break;
        }
    }
}
