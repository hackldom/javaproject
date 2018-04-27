package javafxbusiness;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridView extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			//Parent root = FXMLLoader.load(getClass().getResource("mainGUI.fxml"));
				
			final VBox root = new VBox();
			//Parent root;
			//root.setAlignment(Pos.CENTER);
			//root = FXMLLoader.load(getClass().getResource("mainGui.fxml"));			
			final FXMLLoader loader = new FXMLLoader();	
			final Scene scene = new Scene(root, 400, 300);
			loader.setLocation(getClass().getResource("setupGrid.fxml"));		
	        primaryStage.setTitle("Warehouse Simulation");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
