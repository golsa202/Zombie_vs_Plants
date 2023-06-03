package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MediumLevel extends simpleLevel {

    public AnchorPane anocherpane;
    public Rectangle circle;
    public Button button;
    public Image mediumZombie;
    private int randomY;
    private int randomX;
    private int zombieNum = 12;
    public ImageView imageView;
    private int endgame = 100;
    ArrayList<ImageView> nz = new ArrayList<>();


    public void begin(ActionEvent actionEvent) throws IOException {

        zombieSecondLevel(anocherpane);
        button.setVisible(false);
        circle.setVisible(false);
        makePlants();
        randomMedium();
        startWalking(anocherpane, zombieNum, endgame, scoreText);
        sun(anocherpane);
        sunFlower(imageView);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          super.initialize(url, resourceBundle);
    }

    public void zombieSecLevel(AnchorPane anchorpane) {

        mediumZombie = new Image("Pic/pngwing.com (7).png");
        ImageView zombie = new ImageView(mediumZombie);
        zombie.setX(randomX);
        zombie.setY(randomY);
        zombie.setFitHeight(130);
        zombie.setFitWidth(100);
        zombie.setPreserveRatio(true);
        anchorpane.getChildren().add(zombie);
        imageView = zombie;
        nz.add(imageView);

        for (int b = 0; b < nz.size(); b++) {

            int finalB = b;
            nz.get(b).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    nz.get(finalB).setVisible(false);
                    nz.remove(finalB);
                    zombieScore();
                }
            });
        }
            Timeline t = new Timeline(new KeyFrame(Duration.seconds(0.2), e -> {

                zombie.setX(zombie.getX() - 10);
                conjunctionMedium();

            }));
            t.setCycleCount(100);
            t.play();
        }

    public void conjunctionMedium() {                                   // the conjunction between the second level zombie & plants

            for (double i = 0; i <= 10; i += 0.1) {

                for (int a = 0; a < plants.size(); a++) {

                    for (int b = 0; b < nz.size(); b++) {

                        if (nz.get(b).getX() + i == plants.get(a).getX() && nz.get(b).getY() >= 420 && nz.get(b).getY() <= 480 && plants.get(a).getY() <= 560 && plants.get(a).getY() >= 420) {
                            plants.get(a).setVisible(false);

                        } else if (nz.get(b).getX() + i == plants.get(a).getX() && nz.get(b).getY() >= 200 && nz.get(b).getY() <= 410 && plants.get(a).getY() <= 410 && plants.get(a).getY() >= 200) {
                            plants.get(a).setVisible(false);

                        } else if (nz.get(b).getX() + i == plants.get(a).getX() && nz.get(b).getY() >= 490 && nz.get(b).getY() <= 800 && plants.get(a).getY() <= 800 && plants.get(a).getY() >= 570) {
                            plants.get(a).setVisible(false);
                        }
                    }
                }
            }
        }

    public void zombieSecondLevel(AnchorPane anchorpane )  {                          //Make the special zombie for the second level

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {

            setRandomX();
            zombieSecLevel(anchorpane);
          // conjunctionZP();
            //conjunctionZP();
        }));
        timeline.setCycleCount(10);
        timeline.play();
    }

    public void setRandomX() {                                                         // Random X & Y for the second level zombie

        int[] intArray = { 400 , 550 ,700, 940};
        int[] intY = { 427, 270 , 600 };
        int idx = new Random().nextInt(intArray.length);
        int idy = new Random().nextInt(intY.length);
        randomX = (intArray[idx]);
        randomY = (intY[idy]);
    }

    public void zombieScore(){                                                               // adding 50 scores when the player kills the zombie
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
