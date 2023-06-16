package P11_111502522;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class P11_111502522 extends Application {

	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		Pane pane2 = new Pane();
		// Create a rectangle
		Rectangle rectangle = new Rectangle(0, 0, 100, 25);
		rectangle.setFill(Color.ORANGE);

		// Create a circle
		Circle circle = new Circle(125, 100, 75);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.WHITE);

		// Create a text
		Text text1 = new Text(20, 20, "P11_111502522");

		// Add circle and rectangle to the pane
		pane.getChildren().addAll(circle, rectangle);

		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(circle);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		pt.play(); // Start animation
		//
		FadeTransition ft = new FadeTransition(Duration.seconds(2), pane);
		ft.setFromValue(5);
		ft.setToValue(0.2);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		pane2.getChildren().addAll(text1, pane);
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane2, 250, 200);

		primaryStage.setTitle("P11_111502522"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {

		launch(args);
	}

}
