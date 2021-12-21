import java.util.ArrayList;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car {
	public static int xRat=0;
	public static int yRat=0;
	private static int width=1000;
	private static int height=700;
	private boolean Px = true;
	private boolean Py = true;
	private boolean changing=true;
	private boolean changed=true;
	public CopCar() 
	{
		super ("Cop Car",5000,new Engine("V12",30,100),"cop-car.jpg");
		Random rand=new Random();
		xRat= (rand.nextInt(11)-5);
		yRat= (rand.nextInt(11)-5);
		super.fillUp();
	}
	/*public void update(Graphics g) 
	{
		super.drive(20, xRat, yRat);
		//super.setX(super.getX()+xRat);
		//super.setY(super.getY()+yRat);
		super.update(g);
	}*/
	public void updateState() {
		if(super.getX()<0||super.getX()>width-60||super.getY()<0||super.getY()>height-60) {
			changing=true;
		}else {
			changing=false;
			changed=false;
		}
		if(!changed&&changing) {
			if(super.getX()>width-60||(super.getX()<0)) {
				//System.out.println("Bounce X "+super.getX());
				Px = !Px;
				changed=true;
			}
			if(super.getY()>height-60||(super.getY()<0)) {
				//super.drive(20,xRat,(-1)*yRat);
				//System.out.println("Bounce Y "+super.getY());
				Py = !Py;
				changed=true;
			}
		}
		if(Px&&Py) {
			//System.out.println("1 "+ Px+" "+Py);
			super.drive(2,xRat,yRat);
		}if(Px&&!Py) {
			//System.out.println("2 "+ Px+" "+Py);
			super.drive(2,xRat,(-1)*yRat);
		}if(!Px&&Py) {
			//System.out.println("3 "+ Px+" "+Py);
			super.drive(2,(-1)*xRat,yRat);
		}if(!Px&&!Py) {
			//System.out.println("4 "+ Px+" "+Py);
			super.drive(2,(-1)*xRat,(-1)*yRat);
		}
	}
	public void updateImage(Graphics g) {
		super.update(g);
	}
	public void updateScene(int width,int height){
		//System.out.println(width+" "+height+" x "+super.getX()+" y "+super.getY());
		this.width=width;
		this.height=height;
		//if(width > super.getX() || 0 < super.getX())
		//{
			//Px = !Px;
		//}
		//if(height > super.getY() || 0 < super.getY())
		//{
			//Py = !Py;
		//}
		
	//	if(Px)
		//{
			//if(Py)
			//{
				//drive()
			//}
		//}
		
		
		
	}
}
