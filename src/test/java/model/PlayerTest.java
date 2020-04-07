package model;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

    private Player player;
    private Creature target;

    @Before
    public void beforeEach(){
        target = Mockito.mock(Creature.class);
        player = new Player("John", 100,1,new int[]{10,5,5}, CharacterClass.FIGHTER);
    }

    @Test
    public void testConstructorForEachCharacterClassOption(){
        Assert.assertEquals("Sword;Shield",player.getEquipement());
        Assert.assertEquals(CharacterClass.FIGHTER, player.getCharacterClass());

        player = new Player("Kate", 50,1,new int[]{5,5,10}, CharacterClass.ROGUE);
        Assert.assertEquals("Dagger",player.getEquipement());
        Assert.assertEquals(CharacterClass.ROGUE, player.getCharacterClass());

        player = new Player("Kevin", 50,1,new int[]{5,10,5}, CharacterClass.WIZARD);
        Assert.assertEquals("Magic Staff",player.getEquipement());
        Assert.assertEquals(CharacterClass.WIZARD, player.getCharacterClass());
    }




}
