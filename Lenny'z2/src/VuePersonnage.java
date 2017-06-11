import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class VuePersonnage {
	
	private ImageIcon icone;
	private Image imageDeFond;
	private int etat;
	private ControleurPersonnage controleur;
	private Graphics g;
	private Etat state;
	
	public VuePersonnage(){
		this.etat = 0;
		this.state = Etat.COURS;
		this.controleur = new ControleurPersonnage(this);
		
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
		this.icone = new ImageIcon(getClass().getResource("/Images/Saut.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,0,100,null);
	}
	
	public void rouler(){
		this.icone = new ImageIcon(getClass().getResource("/Images/Roule.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,0,350,null);

		
	}
	
	public void doubleSaut(){
		this.etat = Etat.SAUTE;
		this.position -= 30;
	}
	
	public void seBaisser(){
		this.etat = Etat.SE_BAISSE;
		this.hitBox_Y = 25;
	}
	
	public void courir(){
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
		g.drawImage(this.imageDeFond,0,300,null);
		
	}
}
