package app.gone.treasureloot;

class MagicLotus extends Inhabitant{
	private int petal;
	public MagicLotus(String name,int Px,int Py){
		super(name,Px,Py);
		DataAnalyst.addData(this);
		setPetal(100);
	}
	public MagicLotus(String name){
		super(name);
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
	public void losePetal() {
		setPetal(0);
	}
	public int getPetal() {
		return petal;
	}
	public void setPetal(int petal) {
		this.petal = petal;
	}
}