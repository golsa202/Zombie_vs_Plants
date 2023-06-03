package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Records {
    public TextField show_record;

    public void showRecord(String text){
        show_record.setText("SCORE : " + text);
    }

    public void backToMenu(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage) show_record.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hospital");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
    }
}
