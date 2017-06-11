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
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			this.vue.setState(Etat.SAUTE);
			this.modele.sauter();
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
		this.modele.courir();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	 
}
