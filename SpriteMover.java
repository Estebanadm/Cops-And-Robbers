
public class SpriteMover implements Runnable {
	private Model model;
	private View view;
	SpriteMover(Model model,View view){
		this.model=model;
		this.view=view;
	}
	public void run() {
	    while (true) {

			//... cause the scene to be updated here ...
		
			//... cause the scene to be redrawn here ...
			model.updateScene(view.getWidth(), view.getHeight());
			view.repaint();
	        try {
	            Thread.sleep(2);
	        } catch (InterruptedException e) {}
	    }
	}
	
}
