package Vue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

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
	private static Graphics g;
	private Etat state;
	private int position_X;
	private int position_Y;
	private final int NORMAL = 650;

	private boolean isJumping = false;
	private boolean isJumpingStarted = false;

	// dur�e du saut en ms
	private int jumpPeriod = 200;
	// position dans le temps du saut
	private long jumpIndex;



	public VuePersonnage(){
		this.etat = 0;
		this.state = Etat.COURS;
		this.controleur = new ControleurPersonnage(this);
		this.position_X = 0;
		this.position_Y = NORMAL;

	}

	public int getPosition_X() {
		return position_X;
	}

	public int getPosition_Y() {
		return position_Y;
	}



	public void setState(Etat e){
		this.state = e;
	}

	public void run(Graphics g){
		this.g= g;
		switch (this.state) {
		case SAUTE:
			System.out.println(jumpPeriod);
			if(jumpPeriod == 0){
				jumpPeriod = 500;
				break;
			}
			else if (jumpPeriod > 100){
				jumpPeriod--;
				this.sauter();
				break;
			}
			jumpPeriod--;
			
		case COURS:
			this.courir();
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
		this.position_Y = 400;
		this.icone = new ImageIcon(getClass().getResource("/Images/Saut.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,this.position_X,this.position_Y,null);


	}

	public void rouler(){
		this.position_Y = NORMAL+50;
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
		this.position_Y = NORMAL+50;
		this.icone = new ImageIcon(getClass().getResource("/Images/SeBaisse.png"));
		this.imageDeFond = this.icone.getImage();
		g.drawImage(this.imageDeFond,this.position_X,this.position_Y,null);
	}

	public void courir(){
		this.position_Y = NORMAL;
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
