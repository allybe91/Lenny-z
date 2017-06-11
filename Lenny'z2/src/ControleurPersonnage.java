import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControleurPersonnage implements KeyListener{

	private VuePersonnage vue;
	private ModelePersonnage modele;
	
	public ControleurPersonnage(VuePersonnage vue){
		this.vue = vue;
		this.modele = new ModelePersonnage();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		this.vue.setState(Etat.SAUTE);
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
