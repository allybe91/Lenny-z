

public class Chrono implements Runnable {

	private final int PAUSE = 4 ;
	// hello imbécile
	@Override
	public void run() {
		while(!Main.findDePartie){
			Main.panelDeJeu.xFond--;
			Main.panelDeJeu.xObstacle--;
			Main.panelDeJeu.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {}
		}
		
	}
}
