import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


public class ControleurPersonnage implements KeyListener{

	private VuePersonnage vue;
	private ModelePersonnage modele;
	
	public ControleurPersonnage(VuePersonnage vue){
		this.vue = vue;
		this.modele = new ModelePersonnage();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.modele.getEtat() == Etat.COURS){
			this.modele.sauter();
			this.vue.sauter();
		}
		
	}
	
	 
}
