package fr.sogeti.rpgapp.view;

import javax.swing.*;
import java.awt.*;

public class CombatView extends JFrame {

    public CombatView(){
        super();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        CombatView combatView = new CombatView();




    }
}
