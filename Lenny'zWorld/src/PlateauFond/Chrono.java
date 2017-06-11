package PlateauFond;

public class Chrono implements Runnable {

	private final int PAUSE = 5 ;
	// test
	@Override
	public void run() {
		while(!Main.findDePartie){
			Main.panelDeJeu.xFond--;
			Main.panelDeJeu.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {}
		}
		
	}
}
