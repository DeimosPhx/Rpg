package stuff;

import java.awt.image.BufferedImage;

import javafx.scene.image.Image;

public abstract class Content {
	protected BufferedImage img;
	protected String nom;
	protected boolean visible,solid,pickupable;
	abstract public void setImg(BufferedImage img);
	abstract public BufferedImage getImg();
}
