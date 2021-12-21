import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*; 
import java.util.*; 
class Model
{
    private ArrayList<Sprite> sprite=new ArrayList<Sprite>();
    
    //private CopCar copcar = new CopCar();
	//private RobberCar robbercar=new RobberCar();
    //private ArrayList<Integer> index=new ArrayList<Integer>();
	//private ArrayList<RobberCar> robberCars = new ArrayList<RobberCar>();
	//private ArrayList<CopCar> copCars = new ArrayList<CopCar>();
	private int count=0;

    Model() throws IOException {
    	//Engine engine=new Engine("V8",120,100);
    	//CopCar car1=new CopCar();
    	Bank bank=new Bank();
    	bank.setX(300);
		bank.setY(300);
		sprite.add(bank);
		
    }

    public void update(Graphics g) {
    	for(int i=0;i <sprite.size();i++) {
    		sprite.get(i).updateImage(g);
    	}
    }
    public void createSprite(int x,int y){
    	//Engine engine=new Engine("V8",120,100);
    	Car car1=new Car("",0,null,"red-car.jpg");
    	
    	if(count%2==0) 
    	{
    		CopCar cop=new CopCar();
    		cop.setX(x);
    		cop.setY(y);
    		//copCars.add(cop);
    		car1=cop;
    		sprite.add(car1);
    		count++;
    	}else
    	{
    		RobberCar rob=new RobberCar();
    		rob.setX(300);
    		rob.setY(300);
    		//robberCars.add(rob);
    		car1=rob;
    		sprite.add(car1);
    		//index.add(sprite.size()-1);
    		count++;
    	}
    	
    }
    public ArrayList<Sprite> getSprite(){
    	return sprite;
    }public void updateScene(int width,int height) {
    	//System.out.println("size Initial= "+sprite.size());
    	synchronized(sprite) {
    	Iterator <Sprite> iter = sprite.iterator();
    	while (iter.hasNext()){
    		Sprite s= (Sprite)iter.next();
			s.updateState();
    		s.updateScene(width, height);
			//STOPPED USING THIS BECAUSE IT WAS ADDING THE COPS AGAIN
			/*if(sprite.get(i) instanceof CopCar) {
				copCars.add((CopCar)sprite.get(i));
			}
			if(sprite.get(i) instanceof RobberCar) {
				robberCars.add((RobberCar)sprite.get(i));
			}*/
			
		}
    	
    	while (iter.hasNext()){
    		Sprite s=iter.next();
    		if((s instanceof RobberCar)&&!(((RobberCar) s).hasEscaped())) {
    			sprite.remove(s);
    			System.out.println("I am Freee");
    		}
    	}
    	for(int i=0;i<sprite.size();i++) {
            if(sprite.get(i) instanceof CopCar) {
            	for(int j=0;j<sprite.size();j++) {
            		if(sprite.get(j) instanceof RobberCar) {
            			if(sprite.get(i).overlaps(sprite.get(j))) {
            				((RobberCar) sprite.get(j)).captured();
            			}
            		}
            	}
            }
    			/*if(robberCars.get(j).hasEscaped()) {
    				//System.out.println("size= "+sprite.size());
    				synchronized(sprite)
    				{
    					System.out.println("j= "+ j);
    					sprite.remove((int)index.get(j));
    				}
    				robberCars.remove(j);
    				index.remove(j);
    				j--;
    				//System.out.println("size after = "+sprite.size());
    			}
    		}
    		}
    	}*/
    	}
    	}
    }
    public void initialize() {
    	Bank bank=new Bank();
    	bank.setX(300);
		bank.setY(300);
    	sprite=new ArrayList<Sprite>();
    	sprite.add(bank);
    	RobberCar rob=new RobberCar();
    	rob.reset();
    	
    	//index=new ArrayList<Integer>();
    	//robberCars = new ArrayList<RobberCar>();
    	//copCars = new ArrayList<CopCar>();
    	count=0;
    }
}
