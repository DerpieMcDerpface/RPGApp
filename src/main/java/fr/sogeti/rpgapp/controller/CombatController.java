package fr.sogeti.rpgapp.controller;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombatController {
    private CombatControllerType type;
    private Player player;
    private List<Creature> creaturesList = new ArrayList<>();

    public CombatController(Player player, Creature firstMonster, Creature... monstersList) {
        this.type = CombatControllerType.MULTIPLE_ENEMIES;
        this.player = player;
        this.creaturesList.add(firstMonster);
        this.creaturesList.addAll(Arrays.asList(monstersList));
    }

    public CombatController(Player player, Creature monster) {
        this.type = CombatControllerType.ONE_ON_ONE;
        this.player = player;
        this.creaturesList.add(monster);
    }

    public CombatControllerType getType() {
        return type;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Creature> getCreaturesList() {
        return creaturesList;
    }


    public String playerAttack() {
        return ">" + this.player.getName() + " attacked " + this.creaturesList.get(0).getName() + " for " + this.player.attack(this.creaturesList.get(0)) + " dammage\n";
    }

    public String playerDodge() {
        this.player.dodge();
        return ">" + this.player.getName() + " is dodging !\n";
    }

    //Player spells not implemented yet
    public String playerSpell() {
        return ">" + this.player.getName() + " casted a spell !\n";
    }

    //Player add not implemented yet !
    public String addPlayer() {
        return "";
    }

    public String monsterAttack() {
        return ">" + this.creaturesList.get(0).getName() + " attacked " + this.player.getName() + " for " + this.creaturesList.get(0).attack(this.player) + " dammage\n";
    }

    public String monsterDodge() {
        this.creaturesList.get(0).dodge();
        return ">" + this.creaturesList.get(0).getName() + " is dodging !\n";
    }

    public String monsterSpell() {
        if (this.creaturesList.get(0) instanceof MagicCaster) {
            return ">" + this.creaturesList.get(0).getName() + " cast a spell on " + this.player + " dealing some dammages\n";
        } else {
            return "I cannot cast spells :'(\n";
        }
    }

    //Monster add not implemented yet
    public String addMonster() {
        return "";
    }

    public int updatePlayerHpBar() {
        return this.player.getHealthPoints();
    }

    public int updateMonsterHpBar() {
        return this.creaturesList.get(0).getHealthPoints();
    }

    public int updatePlayerXpBar() {
        return this.player.getExperience();
    }

    public int updatePlayerLevelLabel() { return this.player.getLevel(); }

    public int updateMonsterLevelLabel() { return this.creaturesList.get(0).getLevel(); }

    public String updatePlayerName() {
        return this.player.getName();
    }

    public String updateMonsterName() {
        return this.creaturesList.get(0).getName();
    }
}
