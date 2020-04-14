package fr.sogeti.rpgapp;

import fr.sogeti.rpgapp.controller.CombatController;
import fr.sogeti.rpgapp.controller.CombatControllerType;
import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;
import fr.sogeti.rpgapp.model.realcharacters.Skeleton;
import fr.sogeti.rpgapp.view.CombatUI;

import javax.swing.*;

public class RPGAppMain {

    private CombatController controller;
    private CombatUI userInterface;

    public RPGAppMain() {
    }

    public void setController(Player player, Creature monster) {
        this.controller = new CombatController(player, monster);
    }

    public boolean runFight() {
        if (controller.getType() == CombatControllerType.ONE_ON_ONE) {
            while (controller.getPlayer().getHealthPoints() > 0 && controller.getCreaturesList().get(0).getHealthPoints() > 0) {
                //TO-DO : Implement combat turns for one on one fights


            }
        } else if (controller.getType() == CombatControllerType.MULTIPLE_ENEMIES) {
            // TO-DO Next sprint : implement combat for multiples enemies
        } else {
            // ERROR ?
        }

        return true;
    }

    public static void main(String[] args) {
        RPGAppMain app = new RPGAppMain();

        Player player = new Player("Arthur", 50, 2, new int[]{15, 5, 5}, CharacterClass.FIGHTER);
        Creature monster = new Skeleton(40, 2, new int[]{5, 5, 5});

        CombatUI combatUI = new CombatUI();
        app.setController(player, monster);

        JFrame frame = new JFrame("RPG App");
        frame.setContentPane(combatUI.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);

    }
}
