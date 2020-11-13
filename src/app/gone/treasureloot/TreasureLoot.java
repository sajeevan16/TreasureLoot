package app.gone.treasureloot;

import java.util.ArrayList;

public class TreasureLoot {
    public static void main(String arg[]){
        Lake Nozama = Lake.createLake();
        DataAnalyst dataAnalyst = new DataAnalyst();

        InnocentFish if1 = new InnocentFish("Gold Fish",Nozama);
        InnocentFish if2 = new InnocentFish("Crush Fish",Nozama);
        RubberFish rf1 = new RubberFish("Poly Fish",Nozama);
        RubberFish rf2 = new RubberFish("Styrene Fish",Nozama);
        KillerFish kf1 = new KillerFish("Goonch Fish",Nozama);
        KillerFish kf2 = new KillerFish("Bull Shark",Nozama);

        MagicLotus ml1 = new MagicLotus("Ziziphus Lotus");
        MagicLotus ml2 = new MagicLotus("Snow Lotus");
        MagicLotus ml3 = new MagicLotus("Nymphaea Lotus");
        MagicLotus ml4 = new MagicLotus("Nelumbo Lotus");
        MagicLotus ml5 = new MagicLotus("Saussurea Lotus");

        SuperWarrior w1 = new SuperWarrior("Valkyrie (S)",Nozama);
        NormalWarrior w2 = new NormalWarrior("Goblin (N)",Nozama);
        SuperWarrior w3 = new SuperWarrior("Hog Rider (S)",Nozama);
        NormalWarrior w4 = new NormalWarrior("Wizard (N)",Nozama);



        System.out.println("\nNumber of warriors are "+Warrior.getNoOfWarrior());
        System.out.println("\nName\t\tP_X\tP_Y");

        for (Warrior warrior : dataAnalyst.getWarriorList()) {
            System.out.println(warrior.toString());
        }
        System.out.println("");
        for (Fish fish : dataAnalyst.getFishList()) {
            System.out.println(fish.toString());
        }
        System.out.println("");
        for (MagicLotus ml : dataAnalyst.getLotusList()) {
            System.out.println(ml.toString());
        }

        System.out.println("\n");

        rf1.start();
        rf2.start();
        if1.start();
        if2.start();
        kf1.start();
        kf2.start();

        w1.start();
        w2.start();
        w3.start();
        w4.start();

    }
}
