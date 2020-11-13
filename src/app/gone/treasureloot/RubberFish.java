package app.gone.treasureloot;

class RubberFish extends Fish{
	public RubberFish(String name,Lake Nozama){
		super(name,Nozama);
	}
	public RubberFish(String name,Lake Nozama,int x,int y){
		super(name,Nozama,x,y);
	}
	public void eatFin(){
		Warrior w = (Warrior) Nozama.getObject(0, getPosition()[0], getPosition()[1]);
		System.out.println("Fish ; "+this.getThisName()+" : I eat "+w.getThisName()+"'s Fin");
		w.loseFin();
		w.stopRun();
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
		eatFin();
	}
}
