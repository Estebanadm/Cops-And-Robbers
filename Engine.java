
public class Engine {
	private String engineDescription;
	private int mpg;
	private int maxSpeed;
	
	public Engine(String engine,int MPG,int maximumSpeed) {
		if(engine.length()==0) 
		{
			engineDescription="Generic engine";
		}else 
		{
			engineDescription=engine;
		}
		if(MPG<0) 
		{
			mpg=0;
		}else 
		{
			mpg=MPG;
		}
		if(maximumSpeed<0) 
		{
			maxSpeed=0;
		}else 
		{
			maxSpeed=maximumSpeed;
		}
	}
	public String getDescription() {
		return (engineDescription+"(MPG: "+mpg+", Max speed: "+maxSpeed+")");
	}
	public int getmpg() {
		return mpg;
	}
	public int getmaxSpeed() {
		return maxSpeed;
	}
}
