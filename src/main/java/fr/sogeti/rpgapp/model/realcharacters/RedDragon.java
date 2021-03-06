package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Dragon;

import fr.sogeti.rpgapp.model.characteroptions.Monster;

public class RedDragon extends Creature implements Dragon, Monster {

    private String loot = "Huge amount of gold";
    private int expReward = 500;

    public RedDragon(int healthPoints, int level, int[] stats) {
        super("Red Dragon", healthPoints, level, stats);
    }

    @Override
    public void breath() {
        System.out.println("bouh");
    }

    @Override
    public String makeSound() {
        return "Rawr XD";
    }

    public String getLoot() {
        return this.loot;
    }

    public int getExpReward() {
        return this.expReward;
    }

}
