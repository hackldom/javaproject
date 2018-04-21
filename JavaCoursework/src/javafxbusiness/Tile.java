package javafxbusiness;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tile extends StackPane{

	private Text text = new Text();
	private Button start = new Button();
	
	public Tile() {
		Rectangle border = new Rectangle(50,50);
		border.setFill(null);
		border.setStroke(Color.BLACK);
		text.setStrokeWidth(40);
		border.setFill(Color.ANTIQUEWHITE);
		setAlignment(Pos.CENTER);
		getChildren().addAll(border, text);
		
		//drawRobot();
		
	/*	Image img = new Image(getClass().getResource("/resources/roboto-logo.png").toURI().toString());
		ImageView iv = new ImageView(img);*/
	}
	
	public void drawRobot() {
		text.setText("Robot");
		if(text.setText()!= null){
			
		}
	}
	public void drawChargingPod() {
		text.setText("Charging");
		
	}
}
