package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EndGame {
    public Label show;

    public void endOfGame(String text){
        show.setText("SCORE : " + text);
    }

    public void backToGame(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage) show.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("level.fxml"));
        primaryStage.setTitle("Hospital");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
    }
}
