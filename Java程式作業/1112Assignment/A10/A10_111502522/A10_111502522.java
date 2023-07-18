/*
Assignment 10
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1002-A
*/
package A10_111502522;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class A10_111502522 extends Application {
	@Override
	public void start(Stage primaryStage){
	    
		Circle body1 = new Circle(150, 200, 85, Color.WHITE);
        body1.setStroke(Color.BLACK);
        body1.setStrokeWidth(5);
        Circle body2 = new Circle(150, 130, 65, Color.WHITE);
        body2.setStroke(Color.BLACK);
        body2.setStrokeWidth(5);
        Circle head = new Circle(150, 80, 75, Color.WHITE); 
        head.setStroke(Color.BLACK);
        head.setStrokeWidth(5);
        Circle eye1 = new Circle(130, 70, 10);
        eye1.setFill(Color.BLACK);
        Circle eye2 = new Circle(170, 70, 10);
        eye1.setFill(Color.BLACK);
        Rectangle hat = new Rectangle(120, 5, 60, 40);
        hat.setFill(Color.PURPLE);
        Line leftArm = new Line(100, 130, 20, 90);   
        leftArm.setStrokeWidth(5);
        leftArm.setStroke(Color.BROWN);
        Line rightArm = new Line(200, 130, 280, 90);
        rightArm.setStroke(Color.GREEN);
        rightArm.setStrokeWidth(5);

        Pane pane = new Pane();
        pane.getChildren().addAll(body1, body2, head, eye1, eye2, hat, leftArm, rightArm);
        Scene scene = new Scene(pane , 300, 300);
        
        primaryStage.setTitle("Snowman");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
