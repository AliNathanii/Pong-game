package pong.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle{
    private double speed;
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_HEIGHT = 15;
    private static final int BALL_RADIUS = 15;
    private static final int PADDLE_SPEED = 5;

    public Paddle(double x, double y, double width, double height, double speed) {
        super(x, y, width, height);
        this.speed = speed;
        this.setFill(Color.BLUE);
    }

    public void moveLeft() {
        setX(getX() - speed);
    }

    public void moveRight() {
        setX(getX() + speed);
    }

}
