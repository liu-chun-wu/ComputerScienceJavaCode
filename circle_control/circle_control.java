package circle_control;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class circle_control extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane p = new Pane();
		Circle circle = new Circle(200, 200, 50);
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 400, 400);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(10);
		p.getChildren().addAll(circle);

		bp.setCenter(p);
		circle.requestFocus();
		circle.setOnKeyPressed(action -> {
			switch (action.getCode()) {
				case W:
					circle.setCenterY(circle.getCenterY() - 10);
					break;
				case S:
					circle.setCenterY(circle.getCenterY() + 10);
					break;
				case A:
					circle.setCenterX(circle.getCenterX() - 10);
					break;
				case D:
					circle.setCenterX(circle.getCenterX() + 10);
					break;
				case UP:
					circle.setRadius(circle.getRadius() + 5);
					break;
				case DOWN:
					if (circle.getRadius() > 5) {
						circle.setRadius(circle.getRadius() - 5);
					} else {
						circle.setRadius(circle.getRadius());
					}
					break;
				default:
					break;
			}
		});
		primaryStage.setTitle("ControlCircle"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		launch(args);
	}
}