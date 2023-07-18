package P12_111502522;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class P12_111502522_controler {
	@FXML
	ImageView image;
	Button button;
	Image new_Image = new Image(getClass().getResourceAsStream("picture2.jpg"));

	public void displayImage() {
		image.setImage(new_Image);
	}

}
