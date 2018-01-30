package stuff;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;

public class Item extends Content{
	private boolean pickupable,visible,solid;
	public boolean isPickupable() {
		return pickupable;
	}
	public void setPickupable(boolean pickupable) {
		this.pickupable = pickupable;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isSolid() {
		return solid;
	}
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	private BufferedImage img;
	private String nom;
	public Item(){
		pickupable = false;
		visible = false;
		solid = false;
		nom = "";
		img = null;
	}
	public Item(String name,BufferedImage image, boolean pickupability,boolean visibility,boolean solidity){
		this();
		pickupable = pickupability;
		visible = visibility;
		solid = solidity;
		nom = name;
		img = image;
	}
	public String toString(){
		return " "+nom;
	}
}
