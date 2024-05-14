package pong.pong;

public class Score {
    private int scoreValue;

    public Score() {
        this.scoreValue = 0;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void incrementScore() {
        scoreValue++;
    }
}
