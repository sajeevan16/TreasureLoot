package app.gone.treasureloot;

public abstract class Inhabitant extends Thread {
	String name;
	private int PositionX;
	private int PositionY;
	public Inhabitant(String name) {
		this.name = name;
	}
	public Inhabitant(String name,int x,int y) {
		this.name = name;
		this.PositionX = x;
		this.PositionY = y;
		Lake.addInhabitant(this, x, y);
	}
	public String toString(){
		return(name+"\t"+PositionX+"\t"+PositionY);
	}
	public String getThisName() {
		return this.name;
	}
	public void setPosition(int x,int y) {
		this.PositionX = x;
		this.PositionY = y;
	}
	public int [] getPosition() {
		int [] Position = {PositionX,PositionY};
		return (Position);
	}
}