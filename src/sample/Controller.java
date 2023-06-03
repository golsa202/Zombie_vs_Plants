package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends simpleLevel implements Initializable{

    public Button start_button;
    public AnchorPane anchorpane;
    public TextField score;
    public Button record_button;

    public void start(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage) start_button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("level.fxml"));
        primaryStage.setTitle("CHOOSE THE LEVEL");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flyingZombie();
        secondFlyingZombie();
        AudioClip audioClip = new AudioClip(getClass().getResource("/Audio/Zombie.mp3").toExternalForm());
        audioClip.setCycleCount(1);
        audioClip.play();

    }

    public void flyingZombie(){

        Image image = new Image("Pic/fly (2).png");
        ImageView zombie = new ImageView(image);
        zombie.setX(480);
        zombie.setY(30);
        zombie.setFitHeight(160);
        zombie.setFitWidth(130);
        zombie.setPreserveRatio(true);
        anchorpane.getChildren().add(zombie);

        new Thread() {
            public void run() {
                super.run();

                while (true) {

                    zombie.setY(zombie.getY() + 5);
                    for (double i = 0; i <= 10; i += 0.1) {
                        if (zombie.getY() + i == 180) {
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

    public void secondFlyingZombie(){

        Image image = new Image("Pic/fly (1).png");
        ImageView zombie = new ImageView(image);
        zombie.setX(615);
        zombie.setY(30);
        zombie.setFitHeight(160);
        zombie.setFitWidth(130);
        zombie.setPreserveRatio(true);
        anchorpane.getChildren().add(zombie);

        new Thread() {

            public void run() {
                super.run();

                while (true) {

                    zombie.setY(zombie.getY() + 10);
                    for (double i = 0; i <= 10; i += 0.1) {
                        if (zombie.getY() + i == 350) {
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

    public void showRecords(ActionEvent actionEvent) throws IOException {                     // go to record page

        Stage primaryStage = (Stage) start_button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("records.fxml"));
        primaryStage.setTitle("RECORDS");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();

    }

}
