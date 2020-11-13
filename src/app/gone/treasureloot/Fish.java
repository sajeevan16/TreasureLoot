package app.gone.treasureloot;

abstract class Fish extends Inhabitant{
	Lake Nozama;
	public Fish(String name,Lake Nozama){
		super(name);
		this.Nozama = Nozama;
		int x = 0;
		int y = 0;
		boolean isPlased = false;
		while (!isPlased) {
			x =1 + (int) (Math.random()*9);
			y =1 + (int) (Math.random()*9);
			if(x!=5 && y!=5) {
				isPlased = Lake.addInhabitant(this, x, y);
			}
		}
		setPosition(x,y);
		DataAnalyst.addData(this);
	}
	public Fish(String name,Lake Nozama,int x,int y){
		super(name);
		this.Nozama = Nozama;
		Lake.addInhabitant(this, x, y);
		setPosition(x,y);
		DataAnalyst.addData(this);
	}
	public void eat(){
		System.out.println(name+" : I'm Eating");
	}
}