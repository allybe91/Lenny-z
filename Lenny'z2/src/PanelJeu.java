
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJeu extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image imageDeFond;
	private final int LARGEUR_IMAGE_FOND = 800;
	public int xFond; // détermine abscisse à gauche de la bande fond qui va se déplacer
	public int xObstacle;
	public Obstacle obstacleTrone;
	private VuePersonnage vuePersonnage;
	
	public PanelJeu(){
		this.imageDeFond = new ImageIcon(getClass().getResource("/Images/fondJeu.png")).getImage();

		this.vuePersonnage = new VuePersonnage();
		this.addKeyListener(new ControleurPersonnage(vuePersonnage)); // flux indépendant du programme principal
		this.xFond = 0;
		this.setFocusable(true); //fenetre reagit avec clavier
		this.requestFocusInWindow();
		
		this.xObstacle = 600;
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
		this.obstacleTrone = new Obstacle(this.xObstacle, 575, "/Images/obstacleTrone.png");
		//this.obstacleTrone.setX(this.obstacleTrone.getX() -1);
		int xOstacleTrone = this.obstacleTrone.getX();
		int yOstacleTrone = this.obstacleTrone.getY();
		g.drawImage(this.obstacleTrone.getImg(), xOstacleTrone, yOstacleTrone, null);
	}
	
	
}
