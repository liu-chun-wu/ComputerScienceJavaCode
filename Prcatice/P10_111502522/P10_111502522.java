/*
Practice 10
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1004-A 
*/
package P10_111502522;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class P10_111502522 extends Application {
	@Override
    public void start(Stage stage) {
       
       Group group = new Group();
       Rectangle rectangle1 = new Rectangle(150,150,200,200);
       
       rectangle1.setFill(Color.WHITE);//填充顏色
       group.getChildren().add(rectangle1);     
       
       stage.setTitle("This is P10");
       stage.setScene(new Scene(group,500,500,Color.BLUE));
       stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}