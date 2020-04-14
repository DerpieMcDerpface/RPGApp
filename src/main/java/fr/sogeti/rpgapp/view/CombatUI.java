package fr.sogeti.rpgapp.view;

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

    public CombatUI() {
        //Action listener for players
        attackBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        dodgeBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        spellBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Action listeners for monster
        attackBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        dodgeBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        spellBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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


    public static void main(String[] args) {
        JFrame frame = new JFrame("RPG App");
        frame.setContentPane(new CombatUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);
    }

}
