package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.characteroptions.Undead;
import fr.sogeti.rpgapp.model.characteroptions.UndeadRegen;

public class Vampire extends Creature implements Undead, Monster, MagicCaster {

    private String loot;
    private int expReward = 250;

    public Vampire(int healthPoints, int level, int[] stats) {
        super("Vampire", healthPoints, level, stats);
        this.loot = "Magic item";
    }

    @Override
    public void castSpell(Creature target) {
        int damageDealt = (this.getLevel() * this.getIntelligence()) - (target.getLevel() + target.getIntelligence());
        if (damageDealt < 2) {
            target.takeDamage(2);
            this.heal(1);
        } else {
            target.takeDamage(damageDealt);
            int cappedHeal = target.getHealthPoints();
            int healAmount = damageDealt / 2;
            if (healAmount > cappedHeal) {
                this.heal(cappedHeal);
            } else {
                this.heal(healAmount);
            }

        }
    }

    @Override
    public String makeSound() {
        return "You're a cuck Edward";
    }

    @Override
    public int getExpReward() {
        return this.expReward;
    }


    @Override
    public String getLoot() {
        return this.loot;
    }

    @Override
    public int getHealthRegen() {
        return UndeadRegen.MEDIUM.getValue();
    }
}