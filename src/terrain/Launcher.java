package terrain;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import properties.Properties;

public class Launcher extends Application{
	private static Properties properties = new Properties();
	private Camera mCam;
	private float startX,startY;
	private Terrain map = new Terrain();
	public void start (Stage primaryStage) throws Exception{
		primaryStage.setTitle("Mapping Test");
        Group root = new Group();
        Canvas canvas = new Canvas(properties.HAUTEUR_WINDOW, properties.LARGEUR_WINDOW);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		canvas.setOnMouseClicked(e ->{
			System.out.println("OK");
		});
		canvas.setOnMouseMoved(e ->{
			/*
			 * screen movement
			 * if cursor close to border:
			 * 	detect wich border and move in concequences
			 */
			int marge = 10;
			//TODO make camera move
			//left top corner
			if(marge > e.getX() && marge > e.getY()){
				System.out.println("BORDURE");
				
			}//left bottom corner
			else if(marge > e.getX() && properties.HAUTEUR_WINDOW-marge < e.getY()){
				System.out.println("BORDURE");
			}//right top corner
			else if(properties.LARGEUR_WINDOW-marge < e.getX() && marge > e.getY()){
				System.out.println("BORDURE");
			}//right bottom corner
			else if(properties.LARGEUR_WINDOW-marge < e.getX() && properties.HAUTEUR_WINDOW-marge < e.getY() ){
				System.out.println("BORDURE");
			}//top
			else if(marge > e.getY()){
				System.out.println("BORDURE");
			}//right
			else if(properties.LARGEUR_WINDOW-marge < e.getX()){
				System.out.println("BORDURE");
			}//bottom
			else if(properties.HAUTEUR_WINDOW-marge < e.getY()){
				System.out.println("BORDURE");
			}//left
			else if(marge > e.getX()){
				System.out.println("BORDURE");
			}
			 
			});
	}
	public void draw(GraphicsContext gc){
		gc.clearRect(0, 0, 10*493, 10*421);
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
	public static void main(String[] args) {
		Application.launch(args);
	}
}
