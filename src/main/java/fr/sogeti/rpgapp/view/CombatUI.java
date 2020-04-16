package fr.sogeti.rpgapp.view;

import javax.swing.*;
import java.awt.*;

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


    public CombatUI() {
        addBtn1.setBackground(Color.DARK_GRAY);
        addBtn2.setBackground(Color.DARK_GRAY);
        attackBtn1.setBackground(Color.DARK_GRAY);
        attackBtn2.setBackground(Color.DARK_GRAY);
        dodgeBtn1.setBackground(Color.DARK_GRAY);
        dodgeBtn2.setBackground(Color.DARK_GRAY);
        spellBtn1.setBackground(Color.DARK_GRAY);
        spellBtn2.setBackground(Color.DARK_GRAY);
        logArea.setBackground(Color.GRAY);
        healthBar1.setForeground(Color.GREEN);
        healthBar2.setForeground(Color.GREEN);
    }

    public void switchEnabledPlayerButtons() {
        attackBtn1.setEnabled(true);
        dodgeBtn1.setEnabled(true);
        spellBtn1.setEnabled(true);
        attackBtn2.setEnabled(false);
        dodgeBtn2.setEnabled(false);
        spellBtn2.setEnabled(false);
        mainPanel.repaint();
    }

    public void switchEnabledMonsterButtons() {
        attackBtn1.setEnabled(false);
        dodgeBtn1.setEnabled(false);
        spellBtn1.setEnabled(false);
        attackBtn2.setEnabled(true);
        dodgeBtn2.setEnabled(true);
        spellBtn2.setEnabled(true);
        mainPanel.repaint();
    }

    public void writeMessage(String msg) {
        logArea.append(msg);
    }

    public void disableAll() {
        attackBtn1.setEnabled(false);
        dodgeBtn1.setEnabled(false);
        spellBtn1.setEnabled(false);
        attackBtn2.setEnabled(false);
        dodgeBtn2.setEnabled(false);
        spellBtn2.setEnabled(false);
        mainPanel.repaint();
    }

    public void updateUI(int[] updatedIntValues, String[] updatedStringValues) {
        healthBar1.setValue(updatedIntValues[0]);
        healthBar1.setMaximum(updatedIntValues[1]);
        healthBar2.setValue(updatedIntValues[2]);
        healthBar2.setMaximum(updatedIntValues[3]);
        expBar1.setValue(updatedIntValues[4]);
        expBar1.setMaximum(1000);
        nameLabel1.setText(updatedStringValues[0]);
        nameLabel2.setText(updatedStringValues[1]);
        levelField1.setText(updatedStringValues[2]);
        levelField2.setText(updatedStringValues[3]);
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

}
