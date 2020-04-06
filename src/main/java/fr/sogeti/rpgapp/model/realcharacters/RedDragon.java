package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Dragon;
import fr.sogeti.rpgapp.model.characteroptions.Monster;

public class RedDragon extends Creature implements Dragon, Monster {

    private String loot;
    private static final int xpReward = 5;

    protected RedDragon(String name, int healthPoints, int level, int[] stats, String loot) {
        super(name, healthPoints, level, stats);
        this.loot = loot;
    }

    @Override
    public void breath() {

    }

    @Override
    public void makeSound() {

    }

    public String getLoot() {
        return this.loot;
    }

    public int getExpReward() {
        return this.xpReward;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }
}
