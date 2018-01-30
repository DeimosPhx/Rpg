package terrain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import properties.Properties;

public class Case {
	private static Properties properties = new Properties();
	private static int HAUTEUR = properties.HAUTEUR_CASE;
	private static int LARGEUR = properties.LARGEUR_CASE;
	private boolean empty;
	private BufferedImage bkg;
	private Point2D position;
	public Case(Point2D pos){
		empty = true;
		try{
			bkg = ImageIO.read(new File(this.getClass()+"../../ressources/herbe.png"));
		}catch(Exception e){
			System.err.println("Error: case could not load img");
		}
		this.position = pos;
	}
	public String toString(){
		return "| |";
	}
	public BufferedImage getImg(){
		return bkg;
	}
	public void setImg(BufferedImage img){
		this.bkg = img;
	}
	public int getH(){
		return HAUTEUR;
	}
	public int getL(){
		return LARGEUR;
	}
	public Point2D getPosition(){
		return this.position;
	}
}
