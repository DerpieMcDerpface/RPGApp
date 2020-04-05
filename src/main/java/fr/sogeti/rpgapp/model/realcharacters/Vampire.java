package fr.sogeti.rpgapp.model.realcharacters;

public class Vampire extends Creature implements Undead, Monster, MagicCaster {

    private String loot;
    private static final int xpReward = 250;

    public Vampire(String name, int healthPoints, int level, int[] stats, String loot) {
        super(name, healthPoints, level, stats);
        this.loot = loot;
    }


    @Override
    public void castSpell(Creature target) {
        int damageDealt = (vampire.getLevel() * vampire.getIntelligence()) - (target.getLevel() + target.getIntelligence());
        if (damageDealt < 2) {
            target.takeDamage(2);
            this.heal(1);
        } else {
            target.takeDamage(damageDealt);
            this.heal(damageDealt / 2);
        }
    }

    @Override
    public String makeSound() {
        System.out.println("You're a cuck Edward");
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
