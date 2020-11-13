package app.gone.treasureloot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataAnalyst {
	private static ArrayList<Warrior> warriorList = new ArrayList<Warrior>();
	private static ArrayList<Fish> fishList = new ArrayList<Fish>();
	private static ArrayList<MagicLotus> lotusList = new ArrayList<MagicLotus>();
	private static Warrior winWarrior;
	private static double takedTime;
	private static String  fileName = "Data_Annalyst.txt";
	static FileWriter fileWriter;
	public static void writeFile() {
		try {
			System.out.println("\nFile Writing...");
			fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Treasure Loot into the river - Game Summary");
			bufferedWriter.newLine();
			bufferedWriter.write("===========================================");
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.write(winWarrior.getThisName()+" is Win this Game");
			bufferedWriter.newLine();
			bufferedWriter.write("It finished in "+takedTime+" milli-Sec");
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("Error in Writing File...");
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Warrior> getWarriorList() {
		return warriorList;
	}
	public static ArrayList<Fish> getFishList() {
		return fishList;
	}
	public static ArrayList<MagicLotus> getLotusList() {
		return lotusList;
	}
	public static void addData(Object obj) {
		if (obj instanceof Warrior) {
			warriorList.add((Warrior) obj);
		}
		else if (obj instanceof Fish) {
			fishList.add((Fish) obj);
		}
		else if (obj instanceof MagicLotus){
			lotusList.add((MagicLotus) obj);
		}
	}
	public double getTakedTime() {
		return takedTime;
	}
	public static void setTakedTime(double takedTime1) {
		takedTime = takedTime1;
	}

	public static void setWinner(Warrior winWarrior2) {
		winWarrior = winWarrior2;
	}
}
