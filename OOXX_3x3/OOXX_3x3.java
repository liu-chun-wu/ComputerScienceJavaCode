package OOXX_3x3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class OOXX_3x3 extends Application {

    @Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("OOXX.fxml"));
		Scene scene = new Scene(root, 700, 400);
		stage.setScene(scene);
		stage.setTitle("OOXX遊戲");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}