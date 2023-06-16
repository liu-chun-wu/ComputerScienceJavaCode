package OOXX_3x3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.*;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.FlowPane;

public class OOXX_controller_v2 implements Initializable {
	@FXML
	FlowPane corner00;
	@FXML
	FlowPane corner10;
	@FXML
	FlowPane corner20;
	@FXML
	FlowPane corner01;
	@FXML
	FlowPane corner11;
	@FXML
	FlowPane corner21;
	@FXML
	FlowPane corner02;
	@FXML
	FlowPane corner12;
	@FXML
	FlowPane corner22;
	@FXML
	Label output;

	public int count = 0;
	public String table[][] = new String[3][3];
	public boolean game_over = false;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				table[i][j] = "";
			}
		}
		output.setPrefWidth(300);
		output.setFont(Font.font(null, FontWeight.BOLD, 24));
		output.setText("Game start");
	}

	public void corner00_display() {
		if (game_over == false) {
			add_OX(0, 0, corner00);
			check_game_over();
		}
	}

	public void corner10_display() {
		if (game_over == false) {
			add_OX(1, 0, corner10);
			check_game_over();
		}
	}

	public void corner20_display() {
		if (game_over == false) {
			add_OX(2, 0, corner20);
			check_game_over();
		}
	}

	public void corner01_display() {
		if (game_over == false) {
			add_OX(0, 1, corner01);
			check_game_over();
		}
	}

	public void corner11_display() {
		if (game_over == false) {
			add_OX(1, 1, corner11);
			check_game_over();
		}

	}

	public void corner21_display() {
		if (game_over == false) {
			add_OX(2, 1, corner21);
			check_game_over();
		}
	}

	public void corner02_display() {
		if (game_over == false) {
			add_OX(0, 2, corner02);
			check_game_over();
		}
	}

	public void corner12_display() {
		if (game_over == false) {
			add_OX(1, 2, corner12);
			check_game_over();
		}
	}

	public void corner22_display() {
		if (game_over == false) {
			add_OX(2, 2, corner22);
			check_game_over();
		}
	}

	public void check_game_over() {
		boolean O_win = false;
		boolean X_win = false;

		if (table[0][0].equals("O") && table[0][1].equals("O") && table[0][2].equals("O")) {
			O_win = true;
		} else if (table[1][0].equals("O") && table[1][1].equals("O") && table[1][2].equals("O")) {
			O_win = true;
		} else if (table[2][0].equals("O") && table[2][1].equals("O") && table[2][2].equals("O")) {
			O_win = true;
		} else if (table[0][0].equals("O") && table[1][0].equals("O") && table[2][0].equals("O")) {
			O_win = true;
		} else if (table[0][1].equals("O") && table[1][1].equals("O") && table[2][1].equals("O")) {
			O_win = true;
		} else if (table[0][2].equals("O") && table[1][2].equals("O") && table[2][2].equals("O")) {
			O_win = true;
		} else if (table[0][0].equals("O") && table[1][1].equals("O") && table[2][2].equals("O")) {
			O_win = true;
		} else if (table[0][2].equals("O") && table[1][1].equals("O") && table[2][0].equals("O")) {
			O_win = true;
		} else if (table[0][0].equals("X") && table[0][1].equals("X") && table[0][2].equals("X")) {
			X_win = true;
		} else if (table[1][0].equals("X") && table[1][1].equals("X") && table[1][2].equals("X")) {
			X_win = true;
		} else if (table[2][0].equals("X") && table[2][1].equals("X") && table[2][2].equals("X")) {
			X_win = true;
		} else if (table[0][0].equals("X") && table[1][0].equals("X") && table[2][0].equals("X")) {
			X_win = true;
		} else if (table[0][1].equals("X") && table[1][1].equals("X") && table[2][1].equals("X")) {
			X_win = true;
		} else if (table[0][2].equals("X") && table[1][2].equals("X") && table[2][2].equals("X")) {
			X_win = true;
		} else if (table[0][0].equals("X") && table[1][1].equals("X") && table[2][2].equals("X")) {
			X_win = true;
		} else if (table[0][2].equals("X") && table[1][1].equals("X") && table[2][0].equals("X")) {
			X_win = true;
		}

		if (O_win == true) {
			output.setText("O win !!!");
			game_over = true;
		} else if (X_win == true) {
			output.setText("X win !!!");
			game_over = true;
		} else if (count == 9) {
			output.setText("Game Over , Draw!!!");
			game_over = true;
		}
	}

	public void add_OX(int x_pos, int y_pos, FlowPane pane) {
		if (table[y_pos][x_pos].equals("")) {
			if (count % 2 == 0) {
				Circle O = new Circle(0, 0, 43);
				O.setFill(Color.WHITE);
				O.setStroke(Color.BLACK);
				O.setStrokeWidth(10);
				pane.getChildren().add(O);
				table[y_pos][x_pos] = "O";
			} else {
				Text X = new Text("X");
				X.setFont(Font.font(null, FontWeight.BOLD, 96));
				pane.getChildren().add(X);
				table[y_pos][x_pos] = "X";
			}
			count++;
		}
	}

}