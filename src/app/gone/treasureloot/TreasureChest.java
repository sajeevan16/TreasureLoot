package app.gone.treasureloot;

class TreasureChest{
	String treasure = "This is Treasure Chest";
	private static TreasureChest treasureChest;
	private static int positionX = 5;
	private static int positionY = 5;
	private static Warrior winWarrior;
	private TreasureChest() {}
	public static TreasureChest createTreasureChest() {
		if (treasureChest == null) {
			treasureChest = new TreasureChest();
		}
		return treasureChest;
	}
	
	public static synchronized void stopAllWarriors() {
		for (Warrior warrior : DataAnalyst.getWarriorList()) {
			if ((!(warrior.getPosition()[0]==positionX && warrior.getPosition()[1]==positionY)) && warrior.getAlive()) {
				warrior.stopRun();
				System.out.println(warrior.getThisName()+"  is Stoped");
			}else {
				winWarrior = warrior;
			}
		}
		DataAnalyst.setTakedTime((winWarrior.getEndTime()-winWarrior.getStartTime())/1000000);
		DataAnalyst.setWinner(winWarrior);
		System.out.println(winWarrior.getThisName()+"  is Stoped");
		System.out.println("\n\n"+winWarrior.getThisName()+" is Win this Game\nIt finished in "+((winWarrior.getEndTime()-winWarrior.getStartTime())/1000000)+" milli-Sec");
		DataAnalyst.writeFile();
		winWarrior.stopRun();
	}
}