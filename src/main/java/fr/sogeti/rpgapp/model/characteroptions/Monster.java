package fr.sogeti.rpgapp.model.characteroptions;

public interface Monster {
    String LOOT = "";
    int EXP_REWARD = 0;

    String makeSound();

    int getExpReward();
    String getLoot();
}
