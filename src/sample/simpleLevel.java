package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class simpleLevel extends Zombie implements Initializable {

    public TextField scoreText;
    public AnchorPane anocherpane;
    public Button button;
    public double flowerX, flowerY;
    public ImageView flower;
    public ImageView sun;
    public Image image2;
    public Image sun_flower;
    public ImageView sun1;
    public Image sun_1;
    private int random_loc;
    public int score = 0;
    private int zombieNumber = 7;
    public int simpleEndGame = 100;
    private int a2 = 25;
    private int a3 = 50;

    public static ArrayList<ImageView> plants = new ArrayList<>();                                      //Arraylist for the plants
    public static ArrayList<Circle> shots = new ArrayList<Circle>();
    public static ArrayList<ImageView> sunFlower = new ArrayList<>();                                      //Arraylist for the plants
    public static ArrayList<ImageView> Sun = new ArrayList<>();


    public void start() {

        Circle pile = new Circle();                                                    // making the tirs and ready to shoot
        pile.setCenterX(flowerX + 50);
        pile.setCenterY(flowerY);
        pile.setRadius(10.0f);
        pile.setFill(Color.DARKGREEN);
        pile.setStrokeWidth(8.0);
        anocherpane.getChildren().add(pile);
        shots.add(pile);

        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> {

            pile.setCenterX(pile.getCenterX() + 5);

            conjunction(pile);
            conjunctionHardZombie(pile);
            conjunctionSimpleZombie(pile);
            if (pile.getCenterX() >= 1300) {
                pile.setVisible(false);
            }
        }));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    public void conjunction(Circle circle) {                              //Designed for the first & second level

        for (double i = 0; i <= 5; i += 0.1) {

            for (int a = 0; a < shots.size(); a++) {

                for (int b = 0; b < sz.size(); b++) {

                    if (sz.get(b).getX() + i == shots.get(a).getCenterX() && sz.get(b).getY() >= 411 && sz.get(b).getY() <= 560 && shots.get(a).getCenterY() <= 560 && shots.get(a).getCenterY() >= 411) {
                        shots.get(a).setVisible(false);
                        simpleConjunction();
                        anocherpane.getChildren().remove(sz.get(b));
                        sz.remove(b);

                    } else if (sz.get(b).getX() + i == shots.get(a).getCenterX() && sz.get(b).getY() >= 200 && sz.get(b).getY() <= 410 && shots.get(a).getCenterY() <= 410 && shots.get(a).getCenterY() >= 200) {
                        shots.get(a).setVisible(false);
                        simpleConjunction();
                        anocherpane.getChildren().remove(sz.get(b));
                        sz.remove(b);

                    } else if (sz.get(b).getX() + i == shots.get(a).getCenterX() && sz.get(b).getY() >= 580 && sz.get(b).getY() <= 730 && shots.get(a).getCenterY() <= 730 && shots.get(a).getCenterY() >= 580) {

                        shots.get(a).setVisible(false);
                        simpleConjunction();
                        anocherpane.getChildren().remove(sz.get(b));
                        sz.remove(b);
                    }
                }
            }
        }
    }

    public void conjunctionHardZombie(Circle circle) {                                  //designed for the special suicidal zombie in the third level
        for (double i = 0; i <= 5; i += 0.1) {
            for (int a = 0; a < shots.size(); a++) {

                for (int b = 0; b < hz.size(); b++) {

                    if (hz.get(b).getX() + i == shots.get(a).getCenterX() && hz.get(b).getY() >= 110 && hz.get(b).getY() <= 235 && shots.get(a).getCenterY() <= 235 && shots.get(a).getCenterY() >= 110) {
                        shots.get(a).setVisible(false);
                        hardConjunction();
                        anocherpane.getChildren().remove(hz.get(b));
                        hz.remove(b);

                    } else if (hz.get(b).getX() + i == shots.get(a).getCenterX() && hz.get(b).getY() >= 240 && hz.get(b).getY() <= 370 && shots.get(a).getCenterY() <= 370 && shots.get(a).getCenterY() >= 240) {
                        shots.get(a).setVisible(false);
                        hardConjunction();
                        anocherpane.getChildren().remove(hz.get(b));
                        hz.remove(b);

                    } else if (hz.get(b).getX() + i == shots.get(a).getCenterX() && hz.get(b).getY() >= 370 && hz.get(b).getY() <= 502 && shots.get(a).getCenterY() <= 502 && shots.get(a).getCenterY() >= 370) {
                        shots.get(a).setVisible(false);
                        hardConjunction();
                        anocherpane.getChildren().remove(hz.get(b));
                        hz.remove(b);

                    } else if (hz.get(b).getX() + i == shots.get(a).getCenterX() && hz.get(b).getY() >= 503 && hz.get(b).getY() <= 633 && shots.get(a).getCenterY() <= 633 && shots.get(a).getCenterY() >= 503) {
                        shots.get(a).setVisible(false);
                        hardConjunction();
                        anocherpane.getChildren().remove(hz.get(b));
                        hz.remove(b);

                    } else if (hz.get(b).getX() + i == shots.get(a).getCenterX() && hz.get(b).getY() >= 630 && hz.get(b).getY() <= 800 && shots.get(a).getCenterY() <= 630 && shots.get(a).getCenterY() >= 800) {
                        shots.get(a).setVisible(false);
                        hardConjunction();
                        anocherpane.getChildren().remove(hz.get(b));
                        hz.remove(b);
                    }
                }
            }
        }
    }

    public void hardConjunction() {                                       // suicidal zombie life
        hardZombie_life++;
        if (hardZombie_life == 30 || hardZombie_life == 31 || hardZombie_life == 32) {
            hardZombie_life = 0;
        }
    }

    public void simpleConjunction() {

        zombie_life++;
        if (zombie_life == 20 || zombie_life == 21 || zombie_life == 22) {
            zombie_life = 0;
        }
    }

    public void conjunctionSimpleZombie(Circle circle) {                     // the simple zombie conjunction in level 3

        for (double i = 0; i <= 5; i += 0.1) {
            for (int a = 0; a < shots.size(); a++) {
                for (int b = 0; b < sz2.size(); b++) {

                    if (sz2.get(b).getX() + i == shots.get(a).getCenterX() && sz2.get(b).getY() >= 110 && sz2.get(b).getY() <= 235 && shots.get(a).getCenterY() <= 235 && shots.get(a).getCenterY() >= 110) {
                        shots.get(a).setVisible(false);
                        simpleZombieLife();
                        anocherpane.getChildren().remove(sz2.get(b));
                        sz2.remove(b);

                    } else if (sz2.get(b).getX() + i == shots.get(a).getCenterX() && sz2.get(b).getY() >= 240 && sz2.get(b).getY() <= 370 && shots.get(a).getCenterY() <= 370 && shots.get(a).getCenterY() >= 240) {
                        shots.get(a).setVisible(false);
                        simpleZombieLife();
                        anocherpane.getChildren().remove(sz2.get(b));
                        sz2.remove(b);

                    } else if (sz2.get(b).getX() + i == shots.get(a).getCenterX() && sz2.get(b).getY() >= 370 && sz2.get(b).getY() <= 502 && shots.get(a).getCenterY() <= 502 && shots.get(a).getCenterY() >= 370) {
                        shots.get(a).setVisible(false);
                        simpleZombieLife();
                        anocherpane.getChildren().remove(sz2.get(b));
                        sz2.remove(b);

                    } else if (sz2.get(b).getX() + i == shots.get(a).getCenterX() && sz2.get(b).getY() >= 503 && sz2.get(b).getY() <= 633 && shots.get(a).getCenterY() <= 633 && shots.get(a).getCenterY() >= 503) {
                        shots.get(a).setVisible(false);
                        simpleZombieLife();
                        anocherpane.getChildren().remove(sz2.get(b));
                        sz2.remove(b);

                    } else if (sz2.get(b).getX() + i == shots.get(a).getCenterX() && sz2.get(b).getY() >= 630 && sz2.get(b).getY() <= 800 && shots.get(a).getCenterY() <= 800 && shots.get(a).getCenterY() >= 630) {
                        shots.get(a).setVisible(false);
                        simpleZombieLife();
                        anocherpane.getChildren().remove(sz2.get(b));
                        sz2.remove(b);
                    }
                }
            }
        }
    }

    public void simpleZombieLife() {

        zombie_life++;
        if (zombie_life == 10 || zombie_life == 11 || zombie_life == 12) {
            zombie_life = 0;
        }
    }

    public void begin(ActionEvent actionEvent) throws IOException {

        button.setVisible(false);
        makePlants();
        randomMedium();
        startWalking(anocherpane, zombieNumber, simpleEndGame, scoreText);
        sun(anocherpane);
    }

    public void makePlants() {                                      // This method make plants in ImageView

        Timeline time = new Timeline(new KeyFrame(Duration.seconds(10), ev -> {
            image2 = new Image("pic/pngwing.com (1).png");
            ImageView plant = new ImageView(image2);
            plant.setX(300);
            plant.setY(20);
            plant.setFitHeight(110);
            plant.setFitWidth(80);
            plant.setPreserveRatio(true);
            anocherpane.getChildren().add(plant);
            flower = plant;
            plants.add(flower);
            plant.setOnMouseReleased(new EventHandler<MouseEvent>() {                             //Turn on mouse control for moving plants
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), ev -> {
                        flowerX = mouseEvent.getX();
                        flowerY = mouseEvent.getY();
                        plant.setX(flowerX - 50);
                        plant.setY(flowerY - 50);
                        start();
                    }));
                    scoreSaver(a2);
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                }
            });
        }));
        time.setCycleCount(7);
        time.play();
    }

    public void startShooting(){                                  // start shooting when zombies appear
        for (int a = 0; a < sz2.size(); a++) {
            if (sz2.get(a).getY() <= 800 && sz2.get(a).getY() >= 110) {
                start();
            }
        }
        for (int b = 0; b < sz.size(); b++) {
            if (sz.get(b).getY() <= 800 && sz.get(b).getY() >= 110 ) {
                start();
            }
        }
    }

    public void sun(AnchorPane anchorPane) throws IOException {                                // Sun function Click on each sun to add 50 scores

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(7), ev -> {

            randomSun();
            Image image = new Image("pic/star.png");
            ImageView sun = new ImageView(image);
            sun.setX(random_loc);
            sun.setY(10);
            sun.setFitHeight(100);
            sun.setFitWidth(70);
            sun.setPreserveRatio(true);
            anchorPane.getChildren().add(sun);

            Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> {

                sun.setY(sun.getY() + 5);
            }));
            t.setCycleCount(Animation.INDEFINITE);
            t.play();

            sun.setOnMouseClicked(new EventHandler<MouseEvent>() {                    //Turn on mouse control to click on teh sun & increase the score
                @Override
                public void handle(MouseEvent mouseEvent) {
                    sun.setVisible(false);
                    sunScore();
                }
            });
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void randomSun() {                                              //random location where the suns appear

        int[] intArray = {400, 600, 800, 1000};
        int idy = new Random().nextInt(intArray.length);
        random_loc = (intArray[idy]);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(500));
        scaleTransition.setNode(button);
        scaleTransition.setByX(1.5);
        scaleTransition.setByY(1.5);
        scaleTransition.setCycleCount(10);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    public void scoreSaver(int a) {                                              // Reduce 50 scores

        scoreText.setText(String.valueOf(score -= a));
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("score is : " + score + "\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void conjunctionZP(ImageView plant) {                                                     // When the zombie arrives to where the plant is

        for (double i = 0; i <= 5; i += 0.1) {

            for (int a = 0; a < plants.size(); a++) {

                for (int b = 0; b < hz.size(); b++) {

                    if (hz.get(b).getX() + i == plants.get(a).getX()) {
                        plants.get(b).setVisible(false);
                        plants.remove(b);
                    }
                }
            }
        }
    }

    public void backToMenu(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hospital");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
    }

    public void sunFlower(ImageView imageView) {                                              // Creates sunflower for score section

        Timeline time = new Timeline(new KeyFrame(Duration.seconds(25), ev -> {

            sun_flower = new Image("Pic/sun.png");
            ImageView sunflower = new ImageView(sun_flower);
            sunflower.setX(380);
            sunflower.setY(20);
            sunflower.setFitHeight(110);
            sunflower.setFitWidth(80);
            sunflower.setPreserveRatio(true);
            anocherpane.getChildren().add(sunflower);
            sun = sunflower;
            sunFlower.add(sun);

            sun(sunflower);

        }));
        time.setCycleCount(4);
        time.play();
    }

    public void sun(ImageView ss) {

        for(int b = 0 ; b < sunFlower.size(); b ++) {
            int finalB = b;
            sunFlower.get(b).setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), ev -> {

                        flowerX = mouseEvent.getX();
                        flowerY = mouseEvent.getY();
                        ss.setX(flowerX - 50);
                        ss.setY(flowerY - 50);
                    }));
                    scoreSaver(a3);

                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                    Timeline time1 = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {

                       makeSun(finalB);
                       for (int a = 0; a < Sun.size(); a++) {
                            int finalA = a;
                            Sun.get(a).setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    Sun.get(finalA).setVisible(false);
                                    Sun.remove(finalA);
                                    sunScore();
                                }
                            });
                        } }));
                    time1.setCycleCount(3);
                    time1.play();
                }
            });
        }
    }

    public void makeSun( int com){                                   // make sun for sunflowers

        sun_1 = new Image("Pic/star.png");
        ImageView sunflower = new ImageView(sun_1);
        sunflower.setX(sunFlower.get(com).getX());
        sunflower.setY(sunFlower.get(com).getY() + 20);
        sunflower.setFitHeight(80);
        sunflower.setFitWidth(50);
        sunflower.setPreserveRatio(true);
        anocherpane.getChildren().add(sunflower);
        sun1 = sunflower;
        Sun.add(sunflower);
    }

    public void sunScore(){                                               // Add 50 scores
        scoreText.setText(String.valueOf(score += 50));
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("score is : " + score + "\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

