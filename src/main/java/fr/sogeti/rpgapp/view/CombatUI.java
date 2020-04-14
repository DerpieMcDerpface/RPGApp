package fr.sogeti.rpgapp.view;

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


    public static void main(String[] args) {
        JFrame frame = new JFrame("RPG App");
        frame.setContentPane(new CombatUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200,800);
        frame.setLocationRelativeTo(null);

        Player player = new Player("Arthur",50,2, new int[]{15,5,5}, CharacterClass.FIGHTER);
        Monster monster = new Skeleton(40,2, new int[]{5,5,5});



    }

}
