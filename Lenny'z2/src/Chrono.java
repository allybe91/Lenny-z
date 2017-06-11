

public class Chrono implements Runnable {

	private final int PAUSE = 4 ;
	// hello imbécile
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
