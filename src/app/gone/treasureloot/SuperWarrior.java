package app.gone.treasureloot;

class SuperWarrior extends Warrior{
	boolean hasBinocular = true;
	private static int [] TreasureChestPosition = {5,5};
	public SuperWarrior(String name,Lake Nozama){
		super(name,Nozama);
	}
	public SuperWarrior(String name,Lake Nozama,int Px,int Py){
		super(name,Nozama,Px,Py);
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
	public void eat(){
		System.out.println(name+" is Eating");
	}
	public void sleep(int sec){
		try {
			Thread.sleep((int)(1000*sec));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public boolean searchLotus() {
		int Px = getPosition()[0];
		int Py = getPosition()[1];
		if (Lake.getObject(2,Px+1,Py)!=null && Lake.getObject(2,Px+1,Py) instanceof MagicLotus) {
			if (((MagicLotus)Lake.getObject(2,Px+1,Py)).getPetal()==100) {
				swim("right");
				return true;
			}
		}
		if (Lake.getObject(2,Px-1,Py)!=null && Lake.getObject(2,Px-1,Py) instanceof MagicLotus) {
			if (((MagicLotus)Lake.getObject(2,Px-1,Py)).getPetal()==100) {
				swim("left");
				return true;
			}
		}
		if (Lake.getObject(2,Px,Py+1)!=null && Lake.getObject(2,Px,Py+1) instanceof MagicLotus) {
			if (((MagicLotus)Lake.getObject(2,Px,Py+1)).getPetal()==100) {
				swim("up");
				return true;
			}
		}
		if (Lake.getObject(2,Px,Py-1)!=null && Lake.getObject(2,Px,Py-1) instanceof MagicLotus) {
			if (((MagicLotus)Lake.getObject(2,Px,Py-1)).getPetal()==100) {
				swim("down");
				return true;
			}
		}
		return false;
	}
	public void run() {
		setStartTime(System.nanoTime());
		while (!((getPosition()[1] == TreasureChestPosition[1]) && (getPosition()[0] == TreasureChestPosition[0])) && hasFin) {
			boolean hasmoved = false;
			if(searchLotus()) {continue;}
			if ((getPosition()[0] > TreasureChestPosition[0]) && !hasmoved) {
				hasmoved = swim("left");
				if ((getPosition()[1] == TreasureChestPosition[1]) && !hasmoved) {
					hasmoved = swim("up") && swim("left");	}
				if ((getPosition()[1] == TreasureChestPosition[1]) && !hasmoved) {
					hasmoved = swim("down") && swim("left");	}
			}
			if ((getPosition()[0] < TreasureChestPosition[0]) && !hasmoved) {
				hasmoved = swim("right");
				if ((getPosition()[1] == TreasureChestPosition[1]) && !hasmoved) {
					hasmoved = swim("up") && swim("right");	}
				if ((getPosition()[1] == TreasureChestPosition[1]) && !hasmoved) {
					hasmoved = swim("down") && swim("right");	}
			}
			if ((getPosition()[1] > TreasureChestPosition[1]) && !hasmoved) {
				hasmoved = swim("down");
				if ((getPosition()[0] == TreasureChestPosition[0]) && !hasmoved) {
					hasmoved = swim("left") && swim("down");	}
				if ((getPosition()[0] == TreasureChestPosition[0]) && !hasmoved) {
					hasmoved = swim("right") && swim("down");	}
			}
			if ((getPosition()[1] < TreasureChestPosition[1]) && !hasmoved) {
				hasmoved = swim("up");
				if ((getPosition()[0] == TreasureChestPosition[0]) && !hasmoved) {
					hasmoved = swim("left") && swim("up");	}
				if ((getPosition()[0] == TreasureChestPosition[0]) && !hasmoved) {
					hasmoved = swim("right") && swim("up");	}
			}
		}
	}
}