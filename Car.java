import java.text.DecimalFormat;
import java.awt.Graphics;
public class Car extends Sprite {
	private String carDescription;
	//private int xCor=0;
	//private int yCor=0;
	private GasTank gasTank;
	private Engine engine;
	
	private static DecimalFormat twoDecimal = new DecimalFormat("0.00");
	
	public Car(String description,int maxFuel,Engine reference,String name) {
		super(name);
		if (description.length()==0) {
			carDescription="Generic car";
		}else {
			carDescription= description;
		}
		if(reference==null) {
			engine=new Engine("",0,0);
		}else {
			engine=reference;
		}if(gasTank==null) {
			gasTank=new GasTank(maxFuel);
		}
	}
	public String getDescription() {
		return (carDescription+"(Engine: "+engine.getDescription()+"), fuel: "+twoDecimal.format(gasTank.getLevel())+"/"+gasTank.getCapacity()+", location: ("+getX()+","+getY()+")");
	}
	public double getFuelLevel() {
		return gasTank.getLevel();
	}
	public void setFuelLevel(double level) {
		gasTank.setLevel(level);
	}
	public int getMPG() {
		return engine.getmpg();
	}
	public void fillUp() {
		gasTank.setLevel(gasTank.getCapacity());		
	}
	public int getMaxSpeed() {
		return engine.getmaxSpeed();
	}
	public double drive(int distance, double xRatio, double yRatio) {
		double distancehypothenus=Math.sqrt((Math.pow(xRatio, 2)+Math.pow(yRatio, 2)));
		double ratio=distance/distancehypothenus;
		double usedGas=distance/(double)getMPG();
		double currLevel=gasTank.getLevel();
		double rounded=0;
		if(usedGas>currLevel) {
			rounded = Math.round((currLevel*(double)(getMPG())));
			ratio=rounded/distancehypothenus;
			setX((int)(getX()+Math.floor((xRatio*ratio))));
			setY((int)(getY()+Math.floor((yRatio*ratio))));
			//System.out.println("Ran out of gas after driving "+rounded+" miles");
		}else {
			setX((int)(getX()+Math.floor((xRatio*ratio))));
			setY((int)(getY()+Math.floor((yRatio*ratio))));
			rounded=Math.round((double)distance);
		}
		//System.out.println("usedGas "+usedGas+"currLevel "+currLevel+"\n");
		double tankLevel=currLevel-usedGas;
		gasTank.setLevel(tankLevel);
		
		
		return rounded; 
		
	}
	public void update(Graphics g){
		//super.setX(super.getX()+1);
		//super.setY(super.getY()+1);
		super.updateImage(g);
	}
}