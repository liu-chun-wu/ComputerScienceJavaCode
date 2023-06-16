package A12_111502522;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class A12_111502522 extends Application {

    @Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("A12_111502522.fxml"));
		Scene scene = new Scene(root, 700, 400);
		stage.setScene(scene);
		stage.setTitle("Hello World");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}