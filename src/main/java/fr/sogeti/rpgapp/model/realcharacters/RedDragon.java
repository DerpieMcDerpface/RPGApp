package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Dragon;

import fr.sogeti.rpgapp.model.characteroptions.Monster;

public class RedDragon extends Creature implements Dragon, Monster {

    private String loot;
    private int expReward;

    public RedDragon(int healthPoints, int level, int[] stats) {
        super("Red Dragon", healthPoints, level, stats);
        this.loot = "Huge amount of gold";
        this.expReward = 1000;
    }

    @Override
    public void breath() {
        System.out.println("I'm out of fire... halp!");
    }

    @Override
    public String makeSound() {
        return "Rawr XD";
    }

    public String getLoot() {
        return this.loot;
    }

    public int getExpReward() {
        return expReward;
    }

    public void castSpell(Creature target) {

    }
}
