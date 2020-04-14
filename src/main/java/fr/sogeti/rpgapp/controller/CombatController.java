package fr.sogeti.rpgapp.controller;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombatController {
    private CombatControllerType type;
    private Player player;
    private List<Creature> creaturesList = new ArrayList<Creature>();

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

    public boolean runFight(){
        if(this.type == CombatControllerType.ONE_ON_ONE){
            while (player.getHealthPoints()>0 && creaturesList.get(0).getHealthPoints()>0){
                //TO-DO : Implement combat turns for one on one fights

                

            }
        } else if(this.type = CombatControllerType.MULTIPLE_ENEMIES){
            // TO-DO Next sprint : implement combot for multiples enemies.
        } else {
            // ERROR ?
        }

        return true;
    }


}
