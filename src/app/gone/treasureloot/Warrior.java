package app.gone.treasureloot;

abstract class Warrior extends Inhabitant{
	boolean hasFin = true;
	private boolean alive = true;
	private boolean immortal = false;
	Lake Nozama;
	public static int NoOfWarrior = 0;
	private double StartTime;
	private double EndTime;
	private static int [] TreasureChestPosition = {5,5};
	public Warrior(String name, Lake Nozama){
		super(name);
		this.Nozama = Nozama;
		boolean isPlaced;
		isPlaced = setRandomLocation();
		while (!isPlaced) {isPlaced = setRandomLocation();}
		NoOfWarrior++;
		DataAnalyst.addData(this);
	}
	public Warrior(String name,Lake Nozama,int Px,int Py){
		super(name,Px,Py);
		this.Nozama = Nozama;
		NoOfWarrior++;
		DataAnalyst.addData(this);
	}
	private boolean setRandomLocation() {
		int r1 = (int) (Math.random()*11);
		int [] boder = {0,10};
		int r2 = boder[(int) (Math.random()*2)];
		boolean isPlaced;
		if((int) (Math.random()*2)==0) {
			isPlaced = Lake.addInhabitant(this, r1, r2);
		}
		else {
			isPlaced = Lake.addInhabitant(this, r2, r1);
		}
		return (isPlaced);
	}
	
	public static int getNoOfWarrior(){
		return NoOfWarrior;
	}
	public synchronized boolean swim(String direction){ 
		if(hasFin && getAlive()) {
			this.sleep(1);
			int i=0; int j=0; 
			switch (direction.toLowerCase()) {
			case "up":
				j=1;
				break;
			case "down":
				j=-1;
				break;
			case "right":
				i=1;
				break;
			case "left":
				i=-1;
				break;
			}
			
			int newPositionX = getPosition()[0]+i;
			int newPositionY = getPosition()[1]+j;
				if(Nozama.cheackMoveable(newPositionX,newPositionY)) {
					Nozama.removeInhabitant(this, getPosition()[0], getPosition()[1]); 
					Nozama.addInhabitant(this, newPositionX, newPositionY);
					System.out.println(name+" : "+"I has moved "+direction+", from ("+(newPositionX-i)+","+(newPositionY-j)+") to ("+newPositionX+","+newPositionY+")\n");
					if((getPosition()[1] == TreasureChestPosition[1]) && (getPosition()[0] == TreasureChestPosition[0])) {
						setEndTime(System.nanoTime());
						TreasureChest.stopAllWarriors();
					}
					this.sleep(1);
					return (true);
				}
				else {
					System.out.println(name+" : "+"I Can't Move "+direction+" From ("+(newPositionX-i)+","+(newPositionY-j)+")");
					this.sleep(1);
					return (false);
				}
		}
		return (false);
	}
	public void stopRun() {
		this.stop();
	}
	public void eat(){}
	public void sleep(int sec){
		try {
			Thread.sleep((int)(1000*sec));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void getKill(){
		if (!isImmortal()) {
			Lake.removeInhabitant(this, getPosition()[0], getPosition()[1]);
			this.alive = false;
		}
	}
	public void loseFin(){
		this.hasFin=false;
	}
	public void takeLotus(MagicLotus magicLotus){
		System.out.println(this.getThisName()+" : I take "+magicLotus.getThisName()+", I am also Immortal");
		magicLotus.losePetal();
		setImmortal();
	}
	public void takeTreasureChest(){}
	public boolean getAlive() {
		return alive;
	}
	public boolean isImmortal() {
		return immortal;
	}
	public void setImmortal() {
		this.immortal = true;
	}
	public double getStartTime() {
		return StartTime;
	}
	public void setStartTime(double startTime) {
		StartTime = startTime;
	}
	public double getEndTime() {
		return EndTime;
	}
	public void setEndTime(double endTime) {
		EndTime = endTime;
	}
}