package javafxbusiness;
import javafx.application.*;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import model.ChargingPod;

public class RealRectangle extends Application{
	private Tile tile = new Tile();
	private ChargingPod charging = new ChargingPod();
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(500,500);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * 50);
				tile.setTranslateY(i * 50);
				
				root.getChildren().add(tile);
				if(i < 1) {
					tile.drawRobot();
				}
				if((j < 1) && (i > 0)) {
					tile.drawChargingPod();
				}
				/*for(int k = 1; k < 10; k = k/2 ) {
					tile.drawChargingPod();
				}*/
			}
		
		}			
		return root;
	} 
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		primaryStage.setTitle("Warehouse Simulation");
	}
	public static void main(String[] args) {
		launch(args);
		
	}

}
