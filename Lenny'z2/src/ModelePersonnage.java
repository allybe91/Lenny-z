
public class ModelePersonnage {

	
	
	private float position;
	private float hitBox_X;
	private float hitBox_Y;
	private Etat etat;
	
	public ModelePersonnage(){
		this.etat = Etat.COURS;
		this.hitBox_X = 40;
		this.hitBox_Y = 50;
	}
	
	public void sauter(){
		this.etat = Etat.SAUTE;
		this.position -= 30;
	}
	
	public void rouler(){
		this.etat = Etat.ROULE;
		this.hitBox_Y = 25;
		
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
		this.etat = Etat.COURS;
		this.hitBox_Y = 50;
	}
	
	public Etat getEtat() {
		return etat;
	}

	

}
