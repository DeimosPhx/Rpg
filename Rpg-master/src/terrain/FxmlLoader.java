package terrain;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlLoader extends Application{
	public void start(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Engine.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Moteur RTS [DEV STAGE]");
		stage.setResizable(false);
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
