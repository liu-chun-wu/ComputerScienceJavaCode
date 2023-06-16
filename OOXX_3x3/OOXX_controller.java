package OOXX_3x3;
import javafx.fxml.FXML;
import javafx.scene.shape.*;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.FlowPane;
public class OOXX_controller{ 
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
	
    public void initialize() {
        for(int i=0;i<3;i++)
        {
        	for(int j=0;j<3;j++)
        	{
        		table[i][j]="";
        	}
        }
        output.setPrefWidth(300);
        output.setFont(Font.font(null, FontWeight.BOLD, 24));
        output.setText("Game start");
    } 
	
	public void corner00_display()
	{
		if(game_over == false)
		{
			if(table[0][0].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner00.getChildren().add(O);
					table[0][0]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner00.getChildren().add(X);
					table[0][0]="X";
				}
				count++;
			}
			check_game_over();
		}
	}
	public void corner10_display()
	{
		if(game_over == false)
		{
			if(table[0][1].equals("")) {
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner10.getChildren().add(O);
					table[0][1]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner10.getChildren().add(X);
					table[0][1]="X";
				}
				count++;
			}
			check_game_over();
		}
	}
	public void corner20_display()
	{
		if(game_over == false)
		{
			if(table[0][2].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner20.getChildren().add(O);
					table[0][2]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner20.getChildren().add(X);
					table[0][2]="X";
				}
				count++;
			}
			check_game_over();
		}
	}
	public void corner01_display()
	{
		if(game_over == false)
		{
			if(table[1][0].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner01.getChildren().add(O);
					table[1][0]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner01.getChildren().add(X);
					table[1][0]="X";
				}
				count++;
			}
			check_game_over();
		}
	}
	public void corner11_display()
	{
		if(game_over == false)
		{
			if(table[1][1].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner11.getChildren().add(O);
					table[1][1]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner11.getChildren().add(X);
					table[1][1]="X";
				}
				count++;
			}
		}
		check_game_over();
	}
	public void corner21_display()
	{
		if(game_over == false)
		{
			if(table[1][2].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner21.getChildren().add(O);
					table[1][2]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner21.getChildren().add(X);
					table[1][2]="X";
				}
				count++;
			}
			check_game_over();
		}
	}
	public void corner02_display()
	{
		if(game_over == false)
		{
			if(table[2][0].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner02.getChildren().add(O);
					table[2][0]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner02.getChildren().add(X);
					table[2][0]="X";
				}
				count++;
			}
			check_game_over();
		}
	}
	public void corner12_display()
	{
		if(game_over == false)
		{
			if(table[2][1].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner12.getChildren().add(O);
					table[2][1]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner12.getChildren().add(X);
					table[2][1]="X";
				}
				count++;
			}
			check_game_over();
		}
	}
	public void corner22_display()
	{
		if(game_over == false)
		{
			if(table[2][2].equals(""))
			{
				if(count%2 == 0)
				{
					Circle O = new Circle(0,0,43);
					O.setFill(Color.WHITE);
					O.setStroke(Color.BLACK);
					O.setStrokeWidth(10);
					corner22.getChildren().add(O);
					table[2][2]="O";
				}else {
					Text X = new Text("X");
					X.setFont(Font.font(null, FontWeight.BOLD, 96));
					corner22.getChildren().add(X);
					table[2][2]="X";
				}
				count++;
			}
			check_game_over();
		}	
	}
	public void check_game_over() {
		boolean O_win = false;
		boolean X_win = false;

		if(table[0][0].equals("O") && table[0][1].equals("O") && table[0][2].equals("O")){
			O_win = true;
		}else if(table[1][0].equals("O") && table[1][1].equals("O") && table[1][2].equals("O")){
			O_win = true;
		}else if(table[2][0].equals("O") && table[2][1].equals("O") && table[2][2].equals("O")){
			O_win = true;
		}else if(table[0][0].equals("O") && table[1][0].equals("O") && table[2][0].equals("O")){
			O_win = true;
		}else if(table[0][1].equals("O") && table[1][1].equals("O") && table[2][1].equals("O")){
			O_win = true;
		}else if(table[0][2].equals("O") && table[1][2].equals("O") && table[2][2].equals("O")){
			O_win = true;
		}else if(table[0][0].equals("O") && table[1][1].equals("O") && table[2][2].equals("O")){
			O_win = true;
		}else if(table[0][2].equals("O") && table[1][1].equals("O") && table[2][0].equals("O")){
			O_win = true;
		}else if(table[0][0].equals("X") && table[0][1].equals("X") && table[0][2].equals("X")){
			X_win = true;
		}else if(table[1][0].equals("X") && table[1][1].equals("X") && table[1][2].equals("X")){
			X_win = true;
		}else if(table[2][0].equals("X") && table[2][1].equals("X") && table[2][2].equals("X")){
			X_win = true;
		}else if(table[0][0].equals("X") && table[1][0].equals("X") && table[2][0].equals("X")){
			X_win = true;
		}else if(table[0][1].equals("X") && table[1][1].equals("X") && table[2][1].equals("X")){
			X_win = true;
		}else if(table[0][2].equals("X") && table[1][2].equals("X") && table[2][2].equals("X")){
			X_win = true;
		}else if(table[0][0].equals("X") && table[1][1].equals("X") && table[2][2].equals("X")){
			X_win = true;
		}else if(table[0][2].equals("X") && table[1][1].equals("X") && table[2][0].equals("X")){
			X_win = true;
		}
		
		if(O_win == true){
			output.setText("O win !!!");
			game_over = true;
		}else if (X_win == true){
			output.setText("X win !!!");
			game_over = true;
		}else if(count == 9){
			output.setText("Game Over , Draw!!!");
			game_over = true;
		}
	}
}