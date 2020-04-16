package controller;

import fr.sogeti.rpgapp.controller.CombatControllerType;
import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import fr.sogeti.rpgapp.controller.CombatController;

import java.util.ArrayList;
import java.util.List;

public class CombatControllerTest {
    private CombatController combatController;
    private Player player;
    private Creature monster;

    @Before
    public void beforeEach() {
        monster = Mockito.mock(Creature.class);
        player = new Player("John", 100,1,new int[]{10,5,5}, CharacterClass.FIGHTER);
        combatController = new CombatController(player, monster);
    }

    @Test
    public void testConstructorWithOneMonster() {
        Assert.assertEquals(combatController.getType(), CombatControllerType.ONE_ON_ONE);
        Assert.assertEquals(combatController.getCreaturesList().get(0), monster);
    }

    @Test
    public void testConstructorWithManyMonsters() {
        Creature monster2;
        monster2 = Mockito.mock(Creature.class);
        List<Creature> creaturesList = new ArrayList<>();
        creaturesList.add(monster);
        creaturesList.add(monster2);
        CombatController combatControllerMultipleMonsters = new CombatController(player, monster, monster2);

        Assert.assertEquals(combatControllerMultipleMonsters.getType(), CombatControllerType.MULTIPLE_ENEMIES);
        Assert.assertEquals(combatControllerMultipleMonsters.getCreaturesList(), creaturesList);
        Assert.assertEquals(combatControllerMultipleMonsters.getPlayer(), player);
    }

    @Test
    public void testPlayerAttack() {
        Mockito.when(monster.getName()).thenReturn("monster");
        int damageExpected = player.getLevel() * player.getStrength();
        StringBuffer msgExpected = new StringBuffer();
        msgExpected.append(">John attacked monster for ").append(damageExpected).append(" damage\n");
        Assert.assertEquals(combatController.playerAttack(), msgExpected.toString());
    }

    @Test
    public void testPlayerHpBarReturn() {
        int healthPoints = 100;
        Assert.assertEquals(combatController.updatePlayerHpBar(), 100);
    }

}
