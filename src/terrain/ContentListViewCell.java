package terrain;

import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import stuff.*;
public class ContentListViewCell extends ListCell<Content>{
	@FXML
	Label name;
	@FXML
	ImageView img;
	@FXML
	GridPane grid;
	
	@Override
    protected void updateItem(Content ct, boolean empty) {
        super.updateItem(ct, empty);
        if(empty || ct == null){
        	setText(null);
            setGraphic(null);
        }
        else{
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("customCell.fxml"));
    		loader.setController(this);
    		try{
    			loader.load();
    		}catch(IOException e){
    			e.printStackTrace();
    		}
        	name.setText(ct.toString());
        	img.setImage(SwingFXUtils.toFXImage(ct.getImg(),null));
        	img.setFitWidth(67);
        	img.setFitHeight(99);
        	
        	setText(null);
        	setGraphic(grid);
        }
	}
	
}
