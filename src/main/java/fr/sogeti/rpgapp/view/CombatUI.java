package fr.sogeti.rpgapp.view;

import fr.sogeti.rpgapp.controller.CombatController;
import fr.sogeti.rpgapp.controller.CombatControllerType;
import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.realcharacters.Skeleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombatUI {
    private JPanel mainPanel;
    private JTextArea logArea;
    private JButton attackBtn1;
    private JButton dodgeBtn1;
    private JButton spellBtn1;
    private JButton addBtn1;
    private JButton attackBtn2;
    private JButton dodgeBtn2;
    private JButton spellBtn2;
    private JButton addBtn2;
    private JLabel levelField1;
    private JLabel levelField2;
    private JProgressBar healthBar1;
    private JProgressBar expBar1;
    private JProgressBar healthBar2;
    private JLabel nameLabel2;
    private JLabel nameLabel1;

    private CombatController controller;

    public CombatUI() {
        //Action listener for players
        attackBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO-DO : damage monster and show message in log panel

            }
        });

        dodgeBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO-DO : set Player.isDodging to true and show message in log panel
            }
        });

        spellBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO-DO : use player spell and show message in log panel

            }
        });

        //Action listeners for monster
        attackBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO-DO : damage player and show message in log panel

            }
        });

        dodgeBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO-DO : set Monster.isDodging to true and show message in log panel

            }
        });

        spellBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO-DO : use monster spell and show message in log panel

            }
        });

        addBtn1.setBackground(Color.DARK_GRAY);
        addBtn2.setBackground(Color.DARK_GRAY);
        attackBtn1.setBackground(Color.DARK_GRAY);
        attackBtn2.setBackground(Color.DARK_GRAY);
        dodgeBtn1.setBackground(Color.DARK_GRAY);
        dodgeBtn2.setBackground(Color.DARK_GRAY);
        spellBtn1.setBackground(Color.DARK_GRAY);
        spellBtn2.setBackground(Color.DARK_GRAY);
        logArea.setBackground(Color.GRAY);
    }



    public void switchEnabledPlayerButtons() {
        if (attackBtn1.isEnabled()) {
            spellBtn1.setEnabled(false);
            attackBtn1.setEnabled(false);
            dodgeBtn1.setEnabled(false);
        } else {
            //Spell not implemented for player yet.
            //spellBtn1.setEnabled(true);
            attackBtn1.setEnabled(true);
            dodgeBtn1.setEnabled(true);
        }
    }

    public void switchEnabledMonsterButtons(){
        if (attackBtn2.isEnabled()) {
            spellBtn2.setEnabled(false);
            attackBtn2.setEnabled(false);
            dodgeBtn2.setEnabled(false);
        } else {
            spellBtn2.setEnabled(true);
            attackBtn2.setEnabled(true);
            dodgeBtn2.setEnabled(true);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextArea getLogArea() {
        return logArea;
    }

    public JButton getAttackBtn1() {
        return attackBtn1;
    }

    public JButton getDodgeBtn1() {
        return dodgeBtn1;
    }

    public JButton getSpellBtn1() {
        return spellBtn1;
    }

    public JButton getAddBtn1() {
        return addBtn1;
    }

    public JButton getAttackBtn2() {
        return attackBtn2;
    }

    public JButton getDodgeBtn2() {
        return dodgeBtn2;
    }

    public JButton getSpellBtn2() {
        return spellBtn2;
    }

    public JButton getAddBtn2() {
        return addBtn2;
    }

    public JLabel getLevelField1() {
        return levelField1;
    }

    public JLabel getLevelField2() {
        return levelField2;
    }

    public JProgressBar getHealthBar1() {
        return healthBar1;
    }

    public JProgressBar getExpBar1() {
        return expBar1;
    }

    public JProgressBar getHealthBar2() {
        return healthBar2;
    }

    public JLabel getNameLabel2() {
        return nameLabel2;
    }

    public JLabel getNameLabel1() {
        return nameLabel1;
    }

    public CombatController getController() {
        return controller;
    }
}
