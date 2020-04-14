package fr.sogeti.rpgapp.view;

import javax.swing.*;

public class CombatView extends JFrame {

    public CombatView(){
        super();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        CombatView combatView = new CombatView();
        combatView.setVisible(true);
        combatView.setSize(1200,800);

        

    }
}
