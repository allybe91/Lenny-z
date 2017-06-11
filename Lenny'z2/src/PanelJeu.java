
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJeu extends JPanel{

	private static final long serialVersionUID = 1L;
	private ImageIcon iconeDeFond;
	private Image imageDeFond;
	private final int LARGEUR_IMAGE_FOND = 800;
	public int xFond; // d�termine abscisse � gauche de la bande fond qui va se d�placer
	private VuePersonnage vuePersonnage;
	private Graphics g;
	
	public PanelJeu(){
		this.iconeDeFond = new ImageIcon(getClass().getResource("/Images/fondJeu.png"));
		this.imageDeFond = this.iconeDeFond.getImage();
		
		this.vuePersonnage = new VuePersonnage();
		this.xFond = 0;
		this.setFocusable(true); //fenetre reagit avec clavier
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier()); // flux ind�pendant du programme principal
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
		g.drawImage(this.imageDeFond,this.xFond+LARGEUR_IMAGE_FOND *3,0,null);
		this.vuePersonnage.courir(g);
	}
	
	public void paintComponent(Graphics g){
		this.deplacementFond(g);
	}
	
	
}
