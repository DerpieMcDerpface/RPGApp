package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.characteroptions.Undead;

public class Lich extends Creature implements Undead, Monster, MagicCaster {

    private String loot;
    private static final int xpReward = 250;
    public Lich(String name, int healthPoints, int level, int[] stats, String loot) {
        super(name, healthPoints, level, stats);
        this.loot = loot;
    }

    @Override
    public void castSpell(Creature target) {
        
    }

    @Override
    public void makeSound() {

    }

    public int getHealthRegen() {return this.healthRegen; }

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
