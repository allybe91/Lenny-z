
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJeu extends JPanel{

	private static final long serialVersionUID = 1L;
	private ImageIcon iconeDeFond;
	private Image imageDeFond;
	private final int LARGEUR_IMAGE_FOND = 800;
	public int xFond; // détermine abscisse à gauche de la bande fond qui va se déplacer
	public int xObstacle;
	public Obstacle obstacleCourant;
	private VuePersonnage vuePersonnage;
	private Graphics g;
	
	public PanelJeu(){
		this.iconeDeFond = new ImageIcon(getClass().getResource("/Images/fondJeu.png"));
		this.imageDeFond = this.iconeDeFond.getImage();
		
		this.vuePersonnage = new VuePersonnage();
		this.xFond = 0;
		this.setFocusable(true); //fenetre reagit avec clavier
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier()); // flux indépendant du programme principal
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
		this.xObstacle = 400;
		this.obstacleCourant = new Obstacle(this.xObstacle, -150, "/Images/obstacle1.png");
		
		this.obstacleCourant.setX(this.obstacleCourant.getX() -1);
		g.drawImage(this.obstacleCourant.getImgTuyau(),this.obstacleCourant.getX(), this.obstacleCourant.getY(), null);
		
	}
	
	private void deplacementFond(Graphics g){
		
		if(this.xFond == -this.LARGEUR_IMAGE_FOND){
			this.xFond = 0;
		}
		g.drawImage(this.imageDeFond,this.xFond,0,null);
		g.drawImage(this.imageDeFond,this.xFond+LARGEUR_IMAGE_FOND,0,null);
		g.drawImage(this.imageDeFond,this.xFond+LARGEUR_IMAGE_FOND *2,0,null);
		g.drawImage(this.imageDeFond,this.xFond+LARGEUR_IMAGE_FOND *3,0,null);
		this.vuePersonnage.courir(g);
	}
	
	public void paintComponent(Graphics g){
		this.deplacementFond(g);
	}
	
	
}
