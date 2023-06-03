package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Zombie {

    public int random_location;
    public int random_location1;
    public ImageView imageView;
    private Image image;
    private Image image2;
    public int zombie_life;
    public int hardZombie_life;

    ArrayList<ImageView> sz = new ArrayList<>();
    public static ArrayList<ImageView> hz = new ArrayList<>();
    public static ArrayList<ImageView> sz2 = new ArrayList<>();


    public void startWalking(AnchorPane anchorpane, int zombieComing, int endGame, TextField textField) {                //Simple Zombie for the first and second level

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(7), ev -> {

            image = new Image("Pic/nZombie.png");                                                                    //making zombies
            ImageView zombie1 = new ImageView(image);
            zombie1.setX(1200);
            zombie1.setY(random_location);
            zombie1.setFitHeight(130);
            zombie1.setFitWidth(100);
            zombie1.setPreserveRatio(true);
            anchorpane.getChildren().add(zombie1);
            zombie_life = 0;
            imageView = zombie1;
            sz.add(imageView);

            Timeline t = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

                zombie1.setX(zombie1.getX() - 25);
                zombie1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        zombie1.setVisible(false);
                    }
                });
            }));
            t.setCycleCount(Animation.INDEFINITE);
            t.play();
        }, new javafx.animation.KeyValue[]{}));
        timeline.setCycleCount(zombieComing);
        timeline.play();
        timeline.setOnFinished((finish) ->{
             endGame1(textField);
        });
    }

    public void randomMedium() {                                  //random location where the zombies appear in the second level

        new Thread() {

            public void run() {
                super.run();

                while (true) {
                    int[] intArray = {260, 420, 590};
                    int idx = new Random().nextInt(intArray.length);
                    random_location = (intArray[idx]);
                    try {
                        Thread.sleep(12000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void randomDifficult() {                                  //random location where the simple zombies appear in the third level

        new Thread() {

            public void run() {
                super.run();

                while (true) {
                    int[] intArray = {372, 505, 635, 242, 112};
                    int idx = new Random().nextInt(intArray.length);
                    random_location = (intArray[idx]);
                    try {
                        Thread.sleep(12000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void randomDifficultH() {                                  //random location where the hard zombies appear in the third level

        new Thread() {

            public void run() {
                super.run();

                while (true) {
                    int[] intArray = {372, 505, 635, 242, 112};
                    int idx = new Random().nextInt(intArray.length);
                    random_location1 = (intArray[idx]);
                    try {
                        Thread.sleep(12000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void simpleZombie(AnchorPane anchorpane, int zombieComing, int endGame, TextField textField) {             //Simple Zombie for the third level

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), ev -> {

            image2 = new Image("Pic/nZombie.png");
            ImageView zombie1 = new ImageView(image2);
            zombie1.setX(1200);
            zombie1.setY(random_location);
            zombie1.setFitHeight(130);
            zombie1.setFitWidth(100);
            zombie1.setPreserveRatio(true);
            anchorpane.getChildren().add(zombie1);
            zombie_life = 0;
            imageView = zombie1;
            sz2.add(zombie1);

            Timeline t = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

                zombie1.setX(zombie1.getX() - 15);
                zombie1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        zombie1.setVisible(false);
                    }
                });
            }));
            t.setCycleCount(Animation.INDEFINITE);
            t.play();
        }));
        timeline.setCycleCount(zombieComing);
        timeline.play();
    }

    public void conjunctionZP() {                                                     // When the zombie arrives to where the plant is

        for (double i = 0; i <= 5; i += 0.1) {

            for (int a = 0; a < simpleLevel.plants.size(); a++) {

                for (int b = 0; b < hz.size(); b++) {

                    if (hz.get(b).getX() + i == simpleLevel.plants.get(a).getX()) {

                        simpleLevel.plants.get(a).setVisible(false);
                        simpleLevel.plants.remove(a);
                    }
                }
            }
        }
    }

    public void endGame1(TextField scoreSaver) {                              //winning endgame

        Stage primaryStage = (Stage) imageView.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("endgame.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
        EndGame controller = loader.getController();
        controller.endOfGame(scoreSaver.getText());
        primaryStage.setTitle("end page");
        primaryStage.setScene(new Scene(root, 1500, 900));
        primaryStage.show();
    }
}
