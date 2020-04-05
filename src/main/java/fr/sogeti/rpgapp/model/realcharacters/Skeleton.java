package fr.sogeti.rpgapp.model.realcharacters;

public class Skeleton extends Creature implements Undead, Monster {

    private String loot;
    private static final int xpReward = 5;

    public Skeleton(String name, int healthPoints, int level, int[] stats, String loot) {
        super(name, healthPoints, level, stats);
        this.loot = loot;
    }

    @Override
    public String makeSound() {
        System.out.println("Doot doot !");
    }

    public String getLoot() {
        return this.loot;
    }

    public static int getXpReward() {
        return this.xpReward;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

}
