package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.characteroptions.Undead;

public class Lich extends Creature implements Undead, Monster, MagicCaster {

    private String loot;
    private int expReward = 250;

    public Lich(int healthPoints, int level, int[] stats) {
        super("Arthas", healthPoints, level, stats);
        this.loot = "Magic wand";
        this.expReward = 500;
    }

    @Override
    public void castSpell(Creature target) {
        
    }

    @Override
    public String makeSound() {
        return "Je suis Arthas";
    }

    public int getHealthRegen() {return this.healthRegen; }

    public String getLoot() {
        return this.loot;
    }

    public int getExpReward() {
        return this.expReward;
    }

}
