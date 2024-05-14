package pong.pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PongGame extends Application {
    private static final int PADDLE_WIDTH = 120;
    private static final int PADDLE_HEIGHT = 15;
    private static final int BALL_RADIUS = 15;
    private static final int PADDLE_SPEED = 8;
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT= 800;



    @Override
    public void start(Stage gameStage) {
        Pane root = new Pane();
        Scene gameScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.BLACK);

        gameStage.setScene(gameScene);
        gameStage.setTitle("Pong by Henok, Abenezer, and Ali");

        Paddle paddle = new Paddle((WINDOW_WIDTH - PADDLE_WIDTH) / 2, WINDOW_HEIGHT - 50, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_SPEED);
        Ball ball = new Ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, 3, 3);
        Score score = new Score();
        Text scoreText = new Text("Score: 0");
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        scoreText.setLayoutX(20);
        scoreText.setLayoutY(40);

        root.getChildren().addAll(paddle, ball, scoreText);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            ball.updatePosition();

            if (ball.getBoundsInParent().intersects(paddle.getBoundsInParent())) {
                ball.reverseYDirection();
                scoreText.setText("Score: " + score.getScoreValue());
                // Update score display if needed
            }

            if (ball.getCenterX() <= 0 || ball.getCenterX() >= WINDOW_WIDTH - BALL_RADIUS) {
                ball.reverseXDirection();
            }

            if (ball.getCenterY() <= 0 || ball.getCenterY() >= WINDOW_HEIGHT - BALL_RADIUS) {
                ball.reverseYDirection();
            }

            if (ball.getCenterY() >= WINDOW_HEIGHT - BALL_RADIUS) {
                ball.resetBall();
                // Game over logic
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    paddle.moveLeft();
                } else if (event.getCode() == KeyCode.RIGHT) {
                    paddle.moveRight();
                }
            }
        });

        gameStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}