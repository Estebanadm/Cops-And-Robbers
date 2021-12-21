
public class GasTank {
	private int capacity;
	private double currentLevel;
	
	public GasTank(int capacity) 
	{
		if(capacity>0) {
			this.capacity=capacity;
		}else {
			this.capacity=0;
		}
	}
	public int getCapacity() {
		return capacity;
	}
	public double getLevel() {
		return currentLevel;
	}
	public void setLevel(double levelIn) {
		if(levelIn>0.00) {
			//System.out.println("levelIn = "+levelIn+"Capaciy = "+capacity);
			if(levelIn>capacity) {
				currentLevel=capacity;
			}else {
				currentLevel=levelIn;
			}
		}else {
			currentLevel=0.00;
		}
	}
}