package Vue;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controleur.ControleurPersonnage;
import Modele.Chrono;

public class PanelJeu extends JPanel{

	private static final long serialVersionUID = 1L;
	private final int LARGEUR_IMAGE_FOND = 800;
	private Image imageDeFond;
	public int xFond; // d�termine abscisse � gauche de la bande fond qui va se d�placer
	public static ArrayList<Obstacle> listeObstacles;
	private VuePersonnage vuePersonnage;
	
	public PanelJeu(){
		this.imageDeFond = new ImageIcon(getClass().getResource("/Images/fondJeu.png")).getImage();

		this.vuePersonnage = new VuePersonnage();
		this.addKeyListener(new ControleurPersonnage(vuePersonnage)); // flux ind�pendant du programme principal
		this.xFond = 0;
		this.setFocusable(true); //fenetre reagit avec clavier
		this.requestFocusInWindow();
		
		this.creerObstacles();
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
	}
	
	private void deplacementFond(Graphics g){
		if(this.xFond == -this.LARGEUR_IMAGE_FOND){
			this.xFond = 0;
		}
		g.drawImage(this.imageDeFond,this.xFond,0,null);
		g.drawImage(this.imageDeFond,this.xFond+LARGEUR_IMAGE_FOND,0,null);
		g.drawImage(this.imageDeFond,this.xFond+LARGEUR_IMAGE_FOND *2,0,null);
		//g.drawImage(this.imageDeFond,this.xFond+LARGEUR_IMAGE_FOND *3,0,null);
		this.positionnerObstacles(g);
	}
	
	public void paintComponent(Graphics g){
		this.deplacementFond(g);
		this.vuePersonnage.run(g);
	}
	
	
	private void positionnerObstacles(Graphics g){
		for (Obstacle obstacle : listeObstacles) {
			g.drawImage(obstacle.getImg(), obstacle.getX(), obstacle.getY(), null);
		}
	}
	
	private void creerObstacles(){
		listeObstacles = new ArrayList<>();
		Obstacle obstacleTrone = new Obstacle(600, 575, "/Images/obstacleTrone.png");
		listeObstacles.add(obstacleTrone);
	}
	
}
