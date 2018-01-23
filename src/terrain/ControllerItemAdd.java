package terrain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import stuff.Content;

public class ControllerItemAdd {
	@FXML
	Pane pane;
	@FXML
	Button proceed;
	@FXML
	Button rip;
	@FXML
	CheckBox pickup;
	@FXML
	CheckBox soli;
	@FXML
	CheckBox visi;
	@FXML
	TextField name;
	@FXML
	Button imgLoad;
	
	private boolean isVisible,isSolid,isPickupable,asImg = false;
	private String nom;
	private BufferedImage img;
	private String outPut;
	private String imgUrl;
	public void done(){
		if(asImg){
			isVisible = visi.isSelected();
			isSolid  = soli.isSelected();
			isPickupable = pickup.isSelected();
			nom = name.getText();
			ControllerPrincipale.addItem(nom,isVisible,isSolid,isPickupable,img);
			Stage st = (Stage) pane.getScene().getWindow();
			st.close();
		}
		else{
			System.err.println("IMAGE NOT SETTED !");
		}
	}
	public void escape(){
		Stage st = (Stage) pane.getScene().getWindow();
		st.close();
	}
	public void searchImg(){
		Stage stage = (Stage) pane.getScene().getWindow();
		File imgF = null;
		FileChooser load = new FileChooser();
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
		load.getExtensionFilters().addAll(extFilterJPG,extFilterPNG);
		load.setTitle("Choose your image");
		imgF = load.showOpenDialog(stage);
		img = null;
		try{
			img = ImageIO.read(new File(imgF.toURI().toURL().toExternalForm()));//new Image(imgF.toURI().toURL().toExternalForm());
			imgUrl = imgF.toURI().toURL().toExternalForm();
			asImg = true;
			System.out.println(imgF.toURI().toURL().toExternalForm());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
