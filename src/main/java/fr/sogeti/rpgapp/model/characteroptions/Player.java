package fr.sogeti.rpgapp.model.characteroptions;

public interface Player {
    String equipement = "";
    int money = 0;
    int experience = 0;

    String getEquipement();
    void setEquipement();

    int getMoney();
    void setMoney();

    int getExperience();
    void gainExperience(int expReward);

    void levelUp();
}
