package fr.sogeti.rpgapp.model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.characteroptions.Undead;
import fr.sogeti.rpgapp.model.characteroptions.UndeadRegen;

public class Skeleton extends Creature implements Undead, Monster {

    private String loot;
    private static final int expReward = 5;

    public Skeleton(int healthPoints, int level, int[] stats) {
        super("Skeleton", healthPoints, level, stats);
        this.loot = "No loot";
    }

    @Override
    public String makeSound() {
        return "Doot doot !";
    }

    public String getLoot() {
        return this.loot;
    }

    public int getExpReward() {
        return this.expReward;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    //Test 1
    @Override
    public int getHealthRegen() {
        return UndeadRegen.NONE.getValue();
    }


}
