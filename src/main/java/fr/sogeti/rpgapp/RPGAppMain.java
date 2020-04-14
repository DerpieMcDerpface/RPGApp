package fr.sogeti.rpgapp;

import fr.sogeti.rpgapp.controller.CombatController;
import fr.sogeti.rpgapp.controller.CombatControllerType;
import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;
import fr.sogeti.rpgapp.model.realcharacters.Skeleton;
import fr.sogeti.rpgapp.view.CombatUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPGAppMain {

    private CombatController controller;
    private CombatUI userInterface;

    public RPGAppMain() {
        CombatUI combatUI = new CombatUI();
        this.userInterface = combatUI;

        //Action listener for players
        this.userInterface.getAttackBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.playerAttack());
                redraw();
            }
        });

        this.userInterface.getDodgeBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.playerDodge());
                redraw();
            }
        });

        this.userInterface.getSpellBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(">Wingardium leviosah\n");
                userInterface.getLogArea().append(">Nothing happened\n");
                redraw();
            }
        });

        //Action listeners for monster
        this.userInterface.getAttackBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.monsterAttack());
                redraw();
            }
        });

        this.userInterface.getDodgeBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.monsterDodge());
                redraw();
            }
        });

        this.userInterface.getSpellBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(">Wingardium leviosah\n");
                userInterface.getLogArea().append(">Nothing happened\n");
                redraw();
            }
        });
    }

    public void redraw() {
        this.getCombatUI().getHealthBar1().setValue(this.controller.updatePlayerHpBar());
        this.getCombatUI().getHealthBar2().setValue(this.controller.updateMonsterHpBar());
        this.getCombatUI().getExpBar1().setValue(this.controller.updatePlayerXpBar());
        this.getCombatUI().getNameLabel1().setText(this.controller.updatePlayerName());
        this.getCombatUI().getNameLabel2().setText(this.controller.updateMonsterName());
        this.getCombatUI().getLevelField1().setText("Level : " + Integer.toString(this.controller.updatePlayerLevelLabel()));
        this.getCombatUI().getLevelField2().setText("Level : " + Integer.toString(this.controller.updateMonsterLevelLabel()));
    }

    public void setController(Player player, Creature monster) {
        this.controller = new CombatController(player, monster);
    }

    public CombatController getController() {
        return this.controller;
    }

    public CombatUI getCombatUI() {
        return this.userInterface;
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
        Creature monster = new Skeleton(40, 2, new int[]{10, 10, 10});

        app.setController(player, monster);

        JFrame frame = new JFrame("RPG App");
        frame.setContentPane(app.getCombatUI().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 800);
        app.redraw();
        frame.setLocationRelativeTo(null);



    }
}
