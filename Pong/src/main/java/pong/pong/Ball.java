package pong.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    private static final int BALL_RADIUS = 15;
    private double speedX;
    private double speedY;
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT= 800;

    public Ball(double centerX, double centerY, double speedX, double speedY){
        super(centerX, centerY, BALL_RADIUS);
        this.speedX = speedX;
        this.speedY = speedY;
        this.setFill(Color.WHITE);
    }

    public void updatePosition() {
        setCenterX(getCenterX() + speedX);
        setCenterY(getCenterY() + speedY);
    }

    public void reverseXDirection() {
        speedX *= -1;
    }

    public void reverseYDirection() {
        speedY *= -1;
    }

    public void resetBall() {
        this.setCenterX(WINDOW_WIDTH / 2);
        this.setCenterY(WINDOW_HEIGHT / 2);
    }

}
