package fr.sogeti.rpgapp.model.characteroptions;

public interface Monster {

    String loot = "";
    int expReward = 0;

    String makeSound();

    int getExpReward();
    String getLoot();
}
