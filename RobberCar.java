import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car{
	
	private int xRat=0;
	private int yRat=0;
	private static int capturedCars=0;
	private static int escaped=0;
	boolean captured=false;
	boolean scaped=false;
	private int width=1000;
	private int height=700;
	public RobberCar()
	{
		super ("Robber Car",5000,new Engine("V16",20,200),"red-car.jpg");
		Random rand=new Random();
		xRat= (rand.nextInt(11)-5);
		yRat= (rand.nextInt(11)-5);
		super.fillUp();
	}
	/*public void update(Graphics g) 
	{
		super.drive(40, xRat, yRat);
		//super.setX(super.getX()+xRat);
		//super.setY(super.getY()+yRat);
		super.update(g);
	}*/
	public void updateState() {
		super.drive(4, xRat, yRat);
		if ((super.getX()>=width||super.getX()<=0||super.getY()>=height||super.getY()<=0)&&!hasEscaped()) {
			hasEscaped();
			escaped++;
			scaped=true;
			System.out.println("I am Free");
			//System.out.println("ESCAPED CARS = "+escaped);
		}
	}
	public boolean hasEscaped() {
		if(scaped) {
			return true;
		}
		return false;
	}		
	public void updateImage(Graphics g) {
		super.update(g);
	}
	public void updateScene(int width,int height){
		this.width=width;
		this.height=height;
	}
	public void captured() {
		if(!isCaptured()) {
			super.setImage("jail.jpg");
			super.setFuelLevel(0);
			capturedCars++;
			captured=true;
			System.out.println("Gotcha");			
		}
	}
	boolean isCaptured() {
		if(captured) {
			return true;
		}
		return false;
		
	}
	String capturedAndEscaped() {
		return("Cars Captured = "+capturedCars+" Cars Escaped = "+escaped);
	}void reset(){
		capturedCars=0;
		escaped=0;
	}
}
