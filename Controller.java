import java.util.ArrayList;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        //new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			int x=e.getX();
		    int y=e.getY();
		    //System.out.println(x+","+y);
		    model.createSprite(x, y);
		    view.repaint();
		} else if (SwingUtilities.isRightMouseButton(e))  {
			//System.out.println(e.getX()+"     "+e.getY());
			model.updateScene(view.getWidth(),view.getHeight());
			view.repaint();
			/*ArrayList <Sprite> sprite=model.getSprite();
			for(int i=0;i<sprite.size();i++) {
				((Car)sprite.get(i)).fillUp();
			}*/
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		RobberCar temp = new RobberCar();
		//System.out.println("KeyCode ===="+keyCode);
		if(keyCode==78) {
			System.out.println(temp.capturedAndEscaped());
		}if(keyCode==82) {
			model.initialize();
			view.repaint();
		}if(keyCode==83) {
			Thread t1 = new Thread(new SpriteMover(model,view));
			t1.start();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
}

