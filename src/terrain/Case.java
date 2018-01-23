package terrain;

import java.awt.image.BufferedImage;

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
		bkg = ImageIO.read(this.getClass().getResource("/ressources/herbe.png"));
		}catch(Exception e){
			System.err.println("NIQUE BIEN TA MERE");;
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
