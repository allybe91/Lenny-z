package Modele;
import Vue.Main;
import Vue.Obstacle;
import Vue.PanelJeu;

public class Chrono implements Runnable {

	private final int PAUSE = 4 ;

	@Override
	public void run() {
		while(!Main.findDePartie){
			Main.panelDeJeu.xFond--;
			for(Obstacle obstacle : PanelJeu.listeObstacles){
				obstacle.setX(obstacle.getX() - 1);
			}
			Main.panelDeJeu.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {}
		}
		
	}
}
