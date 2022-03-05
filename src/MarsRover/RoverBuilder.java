package MarsRover;

public class RoverBuilder {
    private Coordinates location;
    private Direction direction;
    private int x;
    private int y;

    public RoverBuilder setLocation(Coordinates location) {
        this.location = location;
        return this;
    }

    public RoverBuilder setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public RoverBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public RoverBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public Rover createRover() {
        return new Rover(location, direction);
    }
}