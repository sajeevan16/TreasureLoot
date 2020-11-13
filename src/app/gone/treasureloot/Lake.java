package app.gone.treasureloot;

public class Lake {
	private static LakeCoordinate coordinate [] []= new LakeCoordinate[11][11];
	private static Lake Nozama;
	private Lake() { 
		for (int i=0; i<=10; i++) {
			for (int j=0; j<=10; j++) {
				coordinate [i][j] = new LakeCoordinate(i,j); 
			}
		}
	}
	public static Lake createLake() {
		if (Nozama == null) {
			Nozama = new Lake();
		}
		return Nozama;
	}
	public static boolean addInhabitant(Inhabitant a,int x,int y) {
		a.setPosition(x,y);
		return coordinate[x][y].addInhabitant(a);
	}
	public static boolean removeInhabitant(Inhabitant a,int x,int y) { 
		return coordinate[x][y].removeInhabitant(a);
	}
	public static boolean cheackMoveable(int x, int y) {
		if (0<=x && x<=10 && 0<=y && y<=10) {
			return coordinate[x][y].cheakMoveable(); 
		}
		return false;
	}
	public static Object getObject(int choice,int x,int y) {
		if (0<=x && x<=10 && 0<=y && y<=10 && choice<3 && choice >=0) {
			return coordinate[x][y].getObject(choice); 
		}
		return false;
	}
	public static LakeCoordinate getCoordinate(int x, int y) {
		return coordinate [x] [y];
	}
}