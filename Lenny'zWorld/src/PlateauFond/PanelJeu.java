package PlateauFond;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJeu extends JPanel{
	// test
	private static final long serialVersionUID = 1L;
	private ImageIcon iconeDeFond;
	private Image imageDeFond;
	private final int LARGEUR_IMAGE_FOND = 800;
	public int xFond; // détermine abscisse à gauche de la bande fond qui va se déplacer
	
	public PanelJeu(){
		this.iconeDeFond = new ImageIcon(getClass().getResource("../img/fondJeu.png"));
		this.imageDeFond = this.iconeDeFond.getImage();
		this.xFond = 0;
		this.setFocusable(true); //fenetre reagit avec clavier
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier()); // flux indépendant du programme principal
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
	}
	
	public void paintComponent(Graphics g){
		this.deplacementFond(g);
	}
	
	
}
