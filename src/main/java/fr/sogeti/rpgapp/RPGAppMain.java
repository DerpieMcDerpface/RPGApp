package fr.sogeti.rpgapp;

import fr.sogeti.rpgapp.controller.CombatController;
import fr.sogeti.rpgapp.controller.CombatControllerType;
import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.realcharacters.Skeleton;
import fr.sogeti.rpgapp.view.CombatUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPGAppMain {

    private CombatController controller;
    private CombatUI userInterface;
    private boolean playerTurn;

    public RPGAppMain() {
        CombatUI combatUI = new CombatUI();
        this.userInterface = combatUI;

        //Action listener for players
        this.userInterface.getAttackBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.playerAttack());
                updateUI();
                playerTurn = false;
            }
        });

        this.userInterface.getDodgeBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.playerDodge());
                updateUI();
                playerTurn = false;
            }
        });

        this.userInterface.getSpellBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(">Wingardium leviosah\n");
                userInterface.getLogArea().append(">Nothing happened\n");
                updateUI();
                playerTurn = false;
            }
        });

        //Action listeners for monster
        this.userInterface.getAttackBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.monsterAttack());
                updateUI();
                playerTurn = true;
            }
        });

        this.userInterface.getDodgeBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(controller.monsterDodge());
                updateUI();
                playerTurn = true;
            }
        });

        this.userInterface.getSpellBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInterface.getLogArea().append(">Wingardium leviosah\n");
                userInterface.getLogArea().append(">Nothing happened\n");
                updateUI();
                playerTurn = true;
            }
        });
    }

    public void updateUI() {
        int playerHealth = this.controller.updatePlayerHpBar();
        int monsterHealth = this.controller.updateMonsterHpBar();
        int playerXP = this.controller.updatePlayerXpBar();
        String playerName = this.controller.updatePlayerName();
        String monsterName = this.controller.updateMonsterName();
        String playerLevel = "Level : " + Integer.toString(this.controller.updatePlayerLevelLabel());
        String monsterLevel = "Level : " + Integer.toString(this.controller.updateMonsterLevelLabel());
        userInterface.updateUI(playerHealth, monsterHealth, playerXP, playerName, monsterName, playerLevel, monsterLevel);
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
        JFrame frame = new JFrame("RPG App");
        frame.setContentPane(this.getCombatUI().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        updateUI();

        this.playerTurn = true;
        if (this.controller.getType() == CombatControllerType.ONE_ON_ONE) {
            while (this.controller.getPlayer().getHealthPoints() > 0 && this.controller.getCreaturesList().get(0).getHealthPoints() > 0) {
                if (this.playerTurn) {
                    this.userInterface.switchEnabledPlayerButtons();
                } else {
                    this.userInterface.switchEnabledMonsterButtons();
                }
            }
            if (this.controller.getPlayer().getHealthPoints() < 0) {
                this.userInterface.writeMessage(">You lost the fight !\n");
            } else if (this.controller.getCreaturesList().get(0).getHealthPoints() < 0) {
                Monster temporaryCast = (Monster) this.controller.getCreaturesList().get(0);
                this.userInterface.writeMessage(">You won the fight !\n");
                StringBuffer sb = new StringBuffer();
                sb.append(">XP won : ").append(temporaryCast.getExpReward()).append("\n").append("Loot earned : ").append(temporaryCast.getLoot()).append("\n");
                this.userInterface.writeMessage(sb.toString());
            }
            userInterface.disableAll();

        } else if (this.controller.getType() == CombatControllerType.MULTIPLE_ENEMIES) {
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
        app.runFight();

        JFrame frame = new JFrame("RPG App");
        frame.setContentPane(app.getCombatUI().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);

        app.runFight();
    }
}
