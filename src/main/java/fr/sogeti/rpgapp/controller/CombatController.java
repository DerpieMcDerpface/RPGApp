package fr.sogeti.rpgapp.controller;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombatController {
    private CombatControllerType type;
    private Player player;
    private List<Creature> creaturesList = new ArrayList<>();

    public CombatController(Player player, Creature firstMonster, Creature... monstersList){
        this.type = CombatControllerType.MULTIPLE_ENEMIES;
        this.player = player;
        this.creaturesList.add(firstMonster);
        this.creaturesList.addAll(Arrays.asList(monstersList));
    }

    public CombatController(Player player, Creature monster){
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
}
