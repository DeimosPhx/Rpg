package terrain;
import javafx.geometry.Point2D;
import properties.Properties;
public class Terrain {
	private static Properties properties = new Properties();
	private static int HAUTEUR = properties.HAUTEUR_MAP;
	private static int LARGEUR = properties.LARGEUR_MAP;
	private Case[][] map;
	public Terrain(){
		map = new Case[HAUTEUR][LARGEUR];
		for(int h = 0; h<HAUTEUR;h++){
			for(int l = 0;l<LARGEUR;l++){
				map[h][l] = new Case(new Point2D(h*100,l*100));
			}
		}
	}
	public int getH(){
		return HAUTEUR;
	}
	public int getL(){
		return LARGEUR;
	}
	public Case[][] getMap(){
		return map;
	}
	public Case getCase(int h,int l){
		return map[h][l];
	}
}
