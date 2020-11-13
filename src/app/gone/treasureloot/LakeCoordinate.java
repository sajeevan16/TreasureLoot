package app.gone.treasureloot;

public class LakeCoordinate {
	int X;
	int Y; // Position
	private Object InhabitantArray[] = new Object[3];

	public LakeCoordinate(int x, int y) {
		this.X = x;
		this.Y = y;
		if ((x == 5) && (y == 5)) {
			TreasureChest treasureChest = TreasureChest.createTreasureChest();
			addInhabitant(treasureChest);
		}
	}
	public boolean addInhabitant(Object a) {
			if (a instanceof Warrior) {
				if (InhabitantArray[0] == null) {
					InhabitantArray[0] = (Warrior) a;
					if(InhabitantArray[1] != null) {
						if (InhabitantArray[1] instanceof RubberFish) {
							System.out.println("notify to RubberFish There is a Warrior's Fin");
							((RubberFish) InhabitantArray[1]).eatFin();
						}
						if (InhabitantArray[1] instanceof KillerFish) {
							System.out.println("notify to KillerFish There is a Warrior.");
							((KillerFish) InhabitantArray[1]).kill();
						}
					}
					if(InhabitantArray[2] instanceof MagicLotus) {
						if (InhabitantArray[2] instanceof MagicLotus) {
							if (!((Warrior) InhabitantArray[0]).isImmortal()){
								System.out.println("notify to Warrior There is a Magic Lotus.");
								((Warrior) InhabitantArray[0]).takeLotus(((MagicLotus) InhabitantArray[2]));
							}
						}
					}
					return (true);
				}
			} else if (a instanceof Fish) {
				if (InhabitantArray[1] == null) {
					InhabitantArray[1] = (Fish) a;
					return (true);
				}
			} else {
				if (InhabitantArray[2] == null) {
					InhabitantArray[2] = a;
					return (true);
				}
			}
			return (false);
	}
	public boolean removeInhabitant(Object a) {
		synchronized (this) {
			if (a instanceof Warrior) {
				if (InhabitantArray[0].equals(a)) {
					InhabitantArray[0] = null;
					return (true);
				}
			} else if (a instanceof Fish) {
				if (InhabitantArray[1] == a) {
					InhabitantArray[1] = null;
					return (true);
				}
			} else {
				if (InhabitantArray[2] == a) {
					InhabitantArray[2] = null;
					return (true);
				}
			}
			return (false);
		}
	}
	public boolean cheakMoveable() {
		synchronized (this) {
			if (InhabitantArray[0] == null) {
				return true;
			}
			return false;
		}
	}
	public boolean cheackLotus() {
		synchronized (this) {
			if (InhabitantArray[3] != null && InhabitantArray[3] instanceof MagicLotus  &&((MagicLotus) InhabitantArray[3]).getPetal()==100) {
				return true;
			}
			return false;
		}
	}

	public Object getObject(int choice) {
		return InhabitantArray[choice];
	}

}