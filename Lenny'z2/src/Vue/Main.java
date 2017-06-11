package Vue;


import javax.swing.JFrame;

public class Main {

	public static JFrame fenetreJeu;
	public static PanelJeu panelDeJeu;
	public static boolean findDePartie;
	
	public static void main(String[]args){
		
		findDePartie = false;
		fenetreJeu = new JFrame("Lenny'z World");
		panelDeJeu = new PanelJeu();
		
		fenetreJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreJeu.setSize(1600, 800);
		fenetreJeu.setLocationRelativeTo(null);
		fenetreJeu.setResizable(false);
		fenetreJeu.setAlwaysOnTop(true);
		fenetreJeu.setContentPane(panelDeJeu);
		fenetreJeu.setVisible(true);
		
	}
	

}
