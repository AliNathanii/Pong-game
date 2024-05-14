module pong.pong {
    requires javafx.controls;
    requires javafx.fxml;


    opens pong.pong to javafx.fxml;
    exports pong.pong;
}