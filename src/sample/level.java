package sample;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class level implements Initializable{

    public Button hard_leve;
    public Button medium;
    public Button easy;
    public ImageView zombie;

    public void hardGame(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage) hard_leve.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("difficult_level.fxml"));
        primaryStage.setTitle("MEDIUM");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
    }

    public void normalGame(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage) hard_leve.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("medium.fxml"));
        primaryStage.setTitle("MEDIUM");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
    }

    public void easyGame(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage) hard_leve.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("simple_level.fxml"));
        primaryStage.setTitle("EASY");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();

    }

    public void enter(MouseEvent mouseEvent) {

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(500));
        scaleTransition.setNode(hard_leve);
        scaleTransition.setByX(1);
        scaleTransition.setByY(1);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    public void nEnter(MouseEvent mouseEvent) {

       ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(500));
        scaleTransition.setNode(medium);
        scaleTransition.setByX(1);
        scaleTransition.setByY(1);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    public void eEnter(MouseEvent mouseEvent) {

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(500));
        scaleTransition.setNode(easy);
        scaleTransition.setByX(1);
        scaleTransition.setByY(1);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonMovement();
    }

    public void buttonMovement(){                              // hard level button

        new Thread() {
            public void run() {
                super.run();

                while (true) {

                    hard_leve.setLayoutY(hard_leve.getLayoutY() + 5);
                    easy.setLayoutY(easy.getLayoutY() - 5);
                    medium.setLayoutX(medium.getLayoutX() + 5);
                    for (double i = 0; i <= 10; i += 0.1) {
                        if (hard_leve.getLayoutY()+ i == 270) {
                            super.stop();
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
