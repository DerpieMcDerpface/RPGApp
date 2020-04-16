package fr.sogeti.rpgapp.model;

import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;

public class Player extends Creature {

    private String equipement;
    private int money;
    private int experience;
    private CharacterClass characterClass;

    public Player(String name, int healthPoints, int level, int[] stats, CharacterClass characterClass) {
        super(name, healthPoints, level, stats);
        this.characterClass = characterClass;
        this.money = 0;
        this.experience = 0;
        switch (characterClass){
            case ROGUE:
                this.equipement = "Dagger";
                break;
            case FIGHTER:
                this.equipement = "Sword;Shield";
                break;
            case WIZARD:
                this.equipement = "Magic Staff";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + characterClass);
        }
    }

    public String getEquipement() {
        return equipement;
    }

    public int getMoney() {
        return money;
    }

    public int getExperience() {
        return experience;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void gainExperience(int expReward){
        this.experience += expReward;
        while(this.experience >= 1000){
            this.setLevel(this.getLevel()+1);
            this.experience -= 1000;
            System.out.println(this.getName()+" a gagné un niveau!");
        }
    }

    public void gainLoot(String loot){
        if(!loot.equals("")&&!loot.equals("None")){
            StringBuilder sb = new StringBuilder();
            if(this.equipement.equals("")){
                this.equipement = loot;
            } else{
                sb.append(equipement).append(";");
                sb.append(loot);
                this.equipement = sb.toString();
            }
        }
    }
    
    @Override
    public int attack(Creature target){
        switch (this.characterClass){
            case ROGUE:
                target.takeDamage(this.getAgility()*this.getLevel());
                return this.getAgility()*this.getLevel();
            case WIZARD:
                target.takeDamage(this.getIntelligence()*this.getLevel());
                return this.getIntelligence()*this.getLevel();
            case FIGHTER:
                target.takeDamage(this.getStrength()*this.getLevel());
                return this.getStrength()*this.getLevel();
            default:
                throw new IllegalStateException("Unexpected value: " + this.characterClass);
        }
    }


}
