package app.gone.treasureloot;

class KillerFish extends Fish{
	public KillerFish(String name,Lake Nozama){
		super(name, Nozama);
	}
	public KillerFish(String name,Lake Nozama,int x,int y){
		super(name,Nozama,x,y);
	}
	public void kill(){
		Warrior w1 = (Warrior) Nozama.getObject(0, getPosition()[0], getPosition()[1]);
		if(!w1.isImmortal()) {
			System.out.println("Fish ; "+this.getThisName()+" : I eat "+w1.getThisName());
			w1.getKill();
			w1.stopRun();
		}
		else {
			System.out.println("Fish ; "+this.getThisName()+" : I Can't kill him, "+w1.getThisName()+" is Imortal");
		}
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		run();
	}
	public void run() {
		System.out.println("Wating for a Warrior..");
		while (Nozama.cheackMoveable(getPosition()[0],getPosition()[1])) {
			try {
				synchronized(Nozama.getCoordinate(getPosition()[0],getPosition()[1])) {
					Nozama.getCoordinate(getPosition()[0],getPosition()[1]).wait();
				}
			}catch(InterruptedException e){}
		}
		kill();
	}
}
