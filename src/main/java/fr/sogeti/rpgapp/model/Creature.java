package fr.sogeti.rpgapp.model;

import fr.sogeti.rpgapp.model.characteroptions.Undead;

public abstract class Creature {

    private String name;
    private int maximumHealth;
    private int healthPoints;
    private int level;
    private int[] stats;
    private boolean isDodging;
    private static final String NEGATIVE_STAT_EXCEPTION = "Error illegal argument, stats can't be negative";

    protected Creature(String name, int healthPoints, int level, int[] stats){
        this.name = name;
        if(healthPoints>0) {
            this.healthPoints = healthPoints;
            this.maximumHealth = healthPoints;
        } else throw new IllegalArgumentException("Error illegal healthPoints argument, must be higher than zero");
        this.level = level;
        this.isDodging = false;

        if(stats.length == 3 && (stats[0]>0 && stats[1]>0 && stats[2]>0)){
            this.stats = stats;
        } else {
            throw new IllegalArgumentException("Error illegal 'stats' argument, stats chould contain 3 positive int values.");
        }
    }

    public int attack(Creature target){
        int attackDamage = 0;
        attackDamage += this.getLevel() + this.getStrength() - target.getLevel();

        if(target.isDodging()) attackDamage -= target.getAgility();
        if(target instanceof Undead) attackDamage /= 2;
        if(attackDamage < 0) attackDamage = 0;

        target.takeDamage(attackDamage);
        return attackDamage;
    }

    public void dodge(){
        this.isDodging = true;
    }

    public void takeDamage(int damage){
        if(damage >= 0){
            this.healthPoints -= damage;
        } else {
            throw new IllegalArgumentException("Error illegal damage argument, damage can't be negative");
        }

    }

    public void heal(int healAmount){
        if(healAmount > 0){
            if(this.healthPoints+healAmount>this.maximumHealth) this.healthPoints = this.maximumHealth;
            else this.healthPoints += healAmount;
        } else {
            throw new IllegalArgumentException("Error illegal healAmount argument, can't heal for a negative value");
        }
    }

    public int getStrength(){
        return this.stats[0];
    }

    public void setStrength(int strength){
        if(strength >= 0){
            this.stats[0] = strength;
        } else {
            throw new IllegalArgumentException(NEGATIVE_STAT_EXCEPTION);
        }
    }

    public int getIntelligence(){
        return this.stats[1];
    }

    public void setIntelligence(int intelligence){
        if(intelligence >= 0){
            this.stats[1] = intelligence;
        } else {
            throw new IllegalArgumentException(NEGATIVE_STAT_EXCEPTION);
        }
    }

    public int getAgility(){
        return this.stats[2];
    }

    public void setAgility(int agility){
        if(agility >= 0){
            this.stats[2] = agility;
        } else {
            throw new IllegalArgumentException(NEGATIVE_STAT_EXCEPTION);
        }
    }

    //CLASSIC GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getLevel() {
        return level;
    }

    protected void setLevel(int level){
        this.level = level;
    }

    public int[] getStats() {
        return stats;
    }

    public boolean isDodging() {
        return isDodging;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }
}
