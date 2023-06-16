//20230505
package Exam.Exam_20230505.E1_111502522;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.animation.*;
import javafx.util.Duration;

public class E1_111502522 extends Application {

	public void start(Stage stage) throws Exception {
		Circle c1 = new Circle(0, 0, 40);
		c1.setFill(Color.WHITE);
		Circle c2 = new Circle(0, 0, 40);
		c2.setFill(Color.WHITE);
		Circle c3 = new Circle(0, 0, 40);
		c3.setFill(Color.WHITE);
		Circle c4 = new Circle(0, 0, 40);
		c4.setFill(Color.WHITE);
		Text text = new Text("111502522");
		GridPane pane = new GridPane();
		pane.add(c1, 1, 0);
		pane.add(c2, 2, 1);
		pane.add(c3, 1, 3);
		pane.add(c4, 0, 1);
		pane.add(text, 0, 0);
		Scene scene = new Scene(pane, 300, 300);
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.ZERO, e -> c1.setFill(Color.BLUE)),
				new KeyFrame(Duration.seconds(1), e -> {
					c1.setFill(Color.WHITE);
					c2.setFill(Color.GREEN);
				}),
				new KeyFrame(Duration.seconds(2), e -> {
					c2.setFill(Color.WHITE);
					c3.setFill(Color.YELLOW);
				}),
				new KeyFrame(Duration.seconds(3), e -> {
					c3.setFill(Color.WHITE);
					c4.setFill(Color.ORANGE);
				}),
				new KeyFrame(Duration.seconds(4), e -> {
					c4.setFill(Color.WHITE);
					c1.setFill(Color.BLUE);
				}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		stage.setTitle("111502522");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
