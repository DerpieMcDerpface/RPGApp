package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Dragon;

import fr.sogeti.rpgapp.model.characteroptions.Monster;

public class RedDragon extends Creature implements Dragon, Monster {

    private String loot;
    private static final int expReward = 5;

    protected RedDragon(String name, int healthPoints, int level, int[] stats) {
        super(name, healthPoints, level, stats);
        this.loot = "Huge amount of gold";
    }

    @Override
    public void breath() {
        
    }

    @Override
    public String makeSound() {
        return "Rawr XD"
    }

    public String getLoot() {
        return this.loot;
    }

    public int getExpReward() {
        return this.expReward;
    }

    public void castSpell(Creature target) {

    }
}
