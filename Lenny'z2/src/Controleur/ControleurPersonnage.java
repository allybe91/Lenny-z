package Controleur;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Modele.Etat;
import Modele.ModelePersonnage;
import Vue.VuePersonnage;


public class ControleurPersonnage implements KeyListener{

	private VuePersonnage vue;
	private ModelePersonnage modele;
	
	public ControleurPersonnage(VuePersonnage vue){
		this.vue = vue;
		this.modele = new ModelePersonnage();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			this.vue.setState(Etat.SAUTE);
			break;
		case KeyEvent.VK_RIGHT:
			this.vue.setState(Etat.ROULE);
			break;
		case KeyEvent.VK_DOWN:
			this.vue.setState(Etat.SE_BAISSE);
			break;
		default:
			this.vue.setState(Etat.SAUTE);
			break;
		}
	
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		this.vue.setState(Etat.COURS);

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	 
}
