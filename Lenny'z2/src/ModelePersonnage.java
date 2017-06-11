
public class ModelePersonnage {

	
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	
	
	public ModelePersonnage(){
		this.x = 0;
		this.y = 700;
		this.largeur = 40;
		this.hauteur = 50;
	}
	
	public void sauter(){
		this.y = 400;
	}
	
	public void rouler(){
		this.y = 400;
		
	}
	
	public void doubleSaut(){
		
	}
	
	public void seBaisser(){
		
	}
	
	public void courir(){
		this.y = 700;
	}
	
	

}
