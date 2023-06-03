package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DifficultLevel extends simpleLevel {

    public Button button;
    public AnchorPane anocherpane;
    private int zombieNumber = 12;
    int endGame = 200;
    public TextField t;
    private Image mine;
    private ImageView imageView;
    private Image hard_zombie;
    private ImageView h_zombie;

    public static ArrayList<ImageView> mines = new ArrayList<>();                                      //Arraylist for the plants

    public void begin(ActionEvent actionEvent) throws IOException {

        button.setVisible(false);
        randomDifficult();
        zombieHardLevel(anocherpane);
        randomDifficultH();
        makePlants();
        simpleZombie(anocherpane, zombieNumber, endGame, t);
        sun(anocherpane);
        mine();
        sunFlower(imageView);
    }

    public void zombieHardLevel(AnchorPane anchorpane) {                                // Special zombie for the third and the hardest level

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), ev -> {

            hard_zombie = new Image("Pic/hard.png");
            ImageView zombie = new ImageView(hard_zombie);
            zombie.setX(1200);
            zombie.setY(random_location1);
            zombie.setFitHeight(130);
            zombie.setFitWidth(110);
            zombie.setPreserveRatio(true);
            anchorpane.getChildren().add(zombie);
            hardZombie_life = 0;
            h_zombie = zombie;
            hz.add(h_zombie);

            Timeline t = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {

                zombie.setX(zombie.getX() - 15);
                conjunctionMZ();
                conjunctionZP();
                zombie.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        zombie.setVisible(false);
                    }
                });
            }));
            t.setCycleCount(Animation.INDEFINITE);
            t.play();
        }));
        timeline.setCycleCount(10);
        timeline.play();
        timeline.setOnFinished((finish) ->{
            endGame1(scoreText);
        });
    }

    public void mine() {                                                                     // Creating mine for the hard level

        Timeline time = new Timeline(new KeyFrame(Duration.seconds(20), ev -> {

            mine = new Image("Pic/mine.png");
            ImageView mine1 = new ImageView(mine);
            mine1.setX(470);
            mine1.setY(20);
            mine1.setFitHeight(100);
            mine1.setFitWidth(80);
            mine1.setPreserveRatio(true);
            anocherpane.getChildren().add(mine1);
            imageView = mine1;
            mines.add(imageView);
            mine1.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), ev -> {

                        flowerX = mouseEvent.getX();
                        flowerY = mouseEvent.getY();
                        mine1.setX(flowerX - 50);
                        mine1.setY(flowerY - 50);
                    }));
                    mineScore();
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                }
            });
        }));
        time.setCycleCount(3);
        time.play();
    }

    public void conjunctionMZ() {                                                                   // The conjunction between zombies and the mine

        for (double i = 0; i <= 10; i += 0.1) {
            for (int a = 0; a < mines.size(); a++) {

                for (int b = 0; b < hz.size(); b++) {

                    for (int c = 0; c < sz2.size(); c++) {

                        if (hz.get(b).getX() + i == mines.get(a).getX()  && mines.get(a).getY() >= 100 || sz2.get(c).getX() + i == mines.get(a).getX()  && mines.get(a).getY() >= 100) {

                            anocherpane.getChildren().remove(mines.get(a));
                            anocherpane.getChildren().remove(hz.get(b));
                            anocherpane.getChildren().remove(sz2.get(c));
                            hz.remove(b);
                            sz2.remove(c);
                            mines.remove(a);
                        }
                    }
                }
            }
        }
    }

    public void mineScore() {                                                  // Reduce the score when the player picks the mine
        scoreText.setText(String.valueOf(score -= 100));
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("score is : " + score + "\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
