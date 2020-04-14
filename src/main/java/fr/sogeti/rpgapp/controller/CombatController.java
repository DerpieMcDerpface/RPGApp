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
        StringBuffer sb = new StringBuffer();
        sb.append(">").append(this.player.getName()).append(" attacked ").append(this.creaturesList.get(0).getName()).append(" for ").append(this.player.attack(this.creaturesList.get(0))).append(" dammage\n");
        return sb.toString();
    }

    public String playerDodge() {
        this.player.dodge();
        StringBuffer sb = new StringBuffer();
        sb.append(">").append(this.player.getName()).append(" is dodging !\n");
        return sb.toString();
    }

    //Player spells not implemented yet
    public String playerSpell() {
        StringBuffer sb = new StringBuffer();
        sb.append(">").append(this.player.getName()).append(" casted a spell !\n");
        return sb.toString();
    }

    //Player add not implemented yet !
    public String addPlayer() {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }

    public String monsterAttack() {
        StringBuffer sb = new StringBuffer();
        sb.append(">").append(this.creaturesList.get(0).getName()).append(" attacked ").append(this.player.getName()).append(" for ").append(this.creaturesList.get(0).attack(this.player)).append(" dammage\n");
        return sb.toString();
    }

    public String monsterDodge() {
        this.creaturesList.get(0).dodge();
        StringBuffer sb = new StringBuffer();
        sb.append(">").append(this.creaturesList.get(0).getName()).append(" is dodging !\n");
        return sb.toString();
    }

    public String monsterSpell() {
        if (this.creaturesList.get(0) instanceof MagicCaster) {
            MagicCaster magicCaster = ((MagicCaster) this.creaturesList.get(0));
            StringBuffer sb = new StringBuffer();
            sb.append(">").append(this.creaturesList.get(0).getName()).append(" cast a spell on ").append(this.player).append(" dealing some dammages\n");
            return sb.toString();
        } else {
            return "I cannot cast spells :'(\n";
        }
    }

    //Monster add not implemented yet
    public String addMonster() {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
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
