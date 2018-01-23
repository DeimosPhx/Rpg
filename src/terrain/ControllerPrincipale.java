package terrain;

import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import stuff.*;

import javax.imageio.ImageIO;
import javax.tools.*;
public class ControllerPrincipale {
	@FXML
	ScrollPane scroll;
	@FXML
	Canvas canvas;
	@FXML
	Button itemAddBt;
	@FXML
	ListView<Content> lst;
	
	private Terrain map;
	private Content selected;
	private static ObservableList<Content> obsList;
	public void initialize(){
		System.out.println("INIT GOING ON...");
		System.out.println("INITIALIZING TERRAIN");
		map = new Terrain();
		System.out.println("INITIALIZING STUFF LIST");
		try{
		BufferedReader br = new BufferedReader(new FileReader(new File("/2DTestGame/data/items.csv")));
		String ligne = null;
		while((ligne=br.readLine())!=null){
			//get la ligne decompsee
			String[] data = ligne.split(";");
			File f = new File(data[1]);
			//get booleans from data
			boolean b1,b2,b3;
			b1=data[2].equals("true");
			b2=data[3].equals("true");
			b3=data[4].equals("true");
			//creation de l'item a partir des data & add it to the list
			try{
				obsList.add(new Item(data[0],ImageIO.read(f),b1,b2,b3));
			}catch(Exception e){
				System.err.println("FDP");
			}
		}
		/*Item herbe = new Item("Herbe", new Image("/ressources/herbe.png"), false, true, false);
		Item rock = new Item("rock", new Image("/ressources/rock.png"), false, true, true);
		*/obsList = FXCollections.observableArrayList();/*
		obsList.addAll(
				herbe,
				rock
				);*/
		br.close();
		}catch(Exception e){
			System.err.println("SOMETHING WENT WRONG: "+e.toString());
		}
		lst.setItems(obsList);
		lst.setCellFactory(contentListView -> new ContentListViewCell());
		paint(canvas.getGraphicsContext2D());
	}
	public static void addItem(String nom,boolean visi,boolean solid,boolean pickup,BufferedImage img){
		Item nw = new Item(nom, img, pickup, visi, solid);
		obsList.add(nw);
	}
	public void OpenItemAdd(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("itemAdd.fxml"));
		Parent root;
		try{
			root = loader.load();
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.setScene(sc);
			st.setTitle("Module d'ajout d'item[DEV]");
			st.show();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void SetContentClicked(MouseEvent e){
		this.selected = lst.getFocusModel().getFocusedItem();
		if(e.isShiftDown()){
			Case[][] tmp = map.getMap();
			boolean found = false;
			for(int i=0;i<tmp.length;i++){
				for(int j=0;j<tmp[i].length;j++){
					if(!found){
						if(e.getX()>tmp[i][j].getPosition().getX() && e.getY()>tmp[i][j].getPosition().getY() && e.getX()<(tmp[i][j].getPosition().getX()+100) && e.getY()<(tmp[i][j].getPosition().getY()+100)){
							System.out.println("i="+i+"\nj="+j);
							map.getCase(i, j).setImg(selected.getImg());
							found = true;
							paint(canvas.getGraphicsContext2D());
						}
					}
				}
			}
		}
	}
	public void exportMap(){
		//save map as a file
		//TODO
		String toSave = "";
		for(int i=0;i<map.getH();i++){
			for(int j=0;j<map.getL();i++){
				if(j == map.getL()-2)
					toSave += map.getCase(i, j).toString();
				else
					toSave += map.getCase(i, j).toString()+"|";
			}
			toSave += "\n";
		}
		//ecriture d'un fichier
	}
	public void paint(GraphicsContext gc){
		gc.clearRect(0, 0, canvas.getHeight(), canvas.getWidth());
		int h,l;
		h = map.getH();
		l = map.getL();
		System.out.println("h="+h);
		System.out.println("l="+l);
		double xM = 0,yM = 0;
		xM =map.getCase(0, 0).getH();
		yM =map.getCase(0, 0).getL();
		for(int i=0;i<h;i++){
			for(int j=0;j<l;j++){//System.out.println("passe boucle \ni="+i+"\nj="+j);
				gc.drawImage(SwingFXUtils.toFXImage(map.getCase(i, j).getImg(),null), i*xM, j*yM);
			}
		}

	}
}
