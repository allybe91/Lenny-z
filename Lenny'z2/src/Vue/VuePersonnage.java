package Vue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controleur.ControleurPersonnage;
import Modele.Etat;


public class VuePersonnage {
	
	private ImageIcon icone;
	private Image imageDeFond;
	private int etat;
	private ControleurPersonnage controleur;
	private Graphics g;
	private Etat state;
	private int position_X;
	private int position_Y;
	
	public VuePersonnage(){
		this.etat = 0;
		this.state = Etat.COURS;
		this.controleur = new ControleurPersonnage(this);
		this.position_X = 0;
		this.position_Y = 300;
		
	}
	
	public void setState(Etat e){
		this.state = e;
	}
	
	public void run(Graphics g){
		this.g= g;
		switch (this.state) {
		case COURS:
			this.courir();
			break;
		case SAUTE:
			this.sauter();
			break;
		case SE_BAISSE:
			this.seBaisser();
			break;
		case ROULE:
			this.rouler();
			break;
		default:
			break;
		}
	}
	
	public void sauter(){
		this.position_Y = 100;
		this.icone = new ImageIcon(getClass().getResource("/Images/Saut.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,this.position_X,this.position_Y,null);
		
		
	}
	
	public void rouler(){
		this.position_Y = 350;
		this.icone = new ImageIcon(getClass().getResource("/Images/Roule.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,this.position_X,this.position_Y,null);

		
	}
	
	public void doubleSaut(){
		this.icone = new ImageIcon(getClass().getResource("/Images/Saut.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,this.position_X,this.position_Y,null);
	}
	
	public void seBaisser(){
		this.position_Y = 350;
		this.icone = new ImageIcon(getClass().getResource("/Images/SeBaisse.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,this.position_X,this.position_Y,null);
	}
	
	public void courir(){
		this.position_Y = 300;
		if(etat <50){
			this.icone = new ImageIcon(getClass().getResource("/Images/Cours.png"));
			this.imageDeFond = this.icone.getImage();
			this.etat ++;
			
		}else{
			this.icone = new ImageIcon(getClass().getResource("/Images/Standing.png"));
			this.imageDeFond = this.icone.getImage();
			this.etat ++;
			if(etat == 100){
				etat = 0;
			}
		}
		g.drawImage(this.imageDeFond,this.position_X,this.position_Y,null);		
	}
}
