/*
Assignment 11
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1002-A
*/
package A11_111502522;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.util.Duration;

public class A11_111502522 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Arc arc = new Arc(100, 100, 70, 70, 0, 45);
		arc.setStrokeWidth(10);
		arc.setStroke(Color.GREEN);
		arc.setType(ArcType.OPEN);

		Pane pane = new Pane();
		Pane pane2 = new Pane();
		pane.getChildren().add(arc);

		Text text = new Text(65, 100, "111502522");
		pane2.getChildren().add(text);

		StackPane rootPane = new StackPane();
		rootPane.getChildren().addAll(pane, pane2);

		RotateTransition rotate = new RotateTransition();
		rotate.setNode(pane);
		rotate.setCycleCount(Timeline.INDEFINITE);
		rotate.setByAngle(360);
		rotate.setDuration(Duration.millis(1000));
		rotate.play();

		Timeline timeline = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(arc.opacityProperty(), 1.0)),
				new KeyFrame(Duration.seconds(1), new KeyValue(arc.opacityProperty(), 0.0)),
				new KeyFrame(Duration.seconds(5), new KeyValue(arc.opacityProperty(), 1.0)),
				new KeyFrame(Duration.seconds(1), action_event -> {
					rotate.stop();
					rotate.setDuration(Duration.millis(5000));
					rotate.play();
				}),
				new KeyFrame(Duration.seconds(5), action_event -> {
					rotate.stop();
					rotate.setDuration(Duration.millis(1000));
					rotate.play();
				}));

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		Scene scene = new Scene(rootPane, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("111502522");
		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}
}