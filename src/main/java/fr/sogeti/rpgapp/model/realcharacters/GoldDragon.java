package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Dragon;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;
import fr.sogeti.rpgapp.model.characteroptions.Monster;

public class GoldDragon extends Creature implements Dragon, MagicCaster, Monster {

    private String loot;
    private int expReward;

    public GoldDragon(int healthPoints, int level, int[] stats) {
        super("Gold Dragon", healthPoints, level, stats);
        this.loot = "Legendary item";
        this.expReward = 1000000;
    }

    @Override
    public void breath() {
        this.heal(this.getMaximumHealth());
    }

    @Override
    public void castSpell(Creature target) {
        target.takeDamage(target.getMaximumHealth());
    }

    @Override
    public String makeSound() {
        return "Walala je suis trop fort";
    }

    @Override
    public int getExpReward() {
        return this.expReward;
    }

    @Override
    public String getLoot() {
        return this.loot;
    }
}
