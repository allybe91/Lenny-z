package Vue;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Obstacle {
	
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private String strImage;
	private Image imageObstacle;
	
	public Obstacle(int x, int y, String strImage){
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		this.imageObstacle = new ImageIcon(getClass().getResource(this.strImage)).getImage();
		this.largeur = this.imageObstacle.getWidth(null);
		this.hauteur = this.imageObstacle.getHeight(null);
	}

	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public int getLargeur() {return largeur;}
	
	public int getHauteur() {return hauteur;}
	
	public Image getImg() {return this.imageObstacle;}

	public void setX(int x) {this.x = x;}
	
	public void setY(int y) {this.y = y;}

}
