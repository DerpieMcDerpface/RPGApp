package model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Dragon;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.realcharacters.GoldDragon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GoldDragonTest {
    Creature target;
    GoldDragon goldDragon;

    @Before
    public void beforeEach(){
        target = Mockito.mock(Creature.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(target.getLevel()).thenReturn(1);
        Mockito.when(target.getIntelligence()).thenReturn(10);
        Mockito.when(target.getHealthPoints()).thenReturn(100);
        goldDragon = new GolDragon(1000, 20, [15,10,12]);
    }

    @Test
    public void testDefaultConstructorValues(){
        Assert.assertEquals("Gold Dragon",goldDragon.getName());
        Assert.assertEquals(100000000, goldDragon.getExpReward());
        Assert.assertEquals("Legendary item", goldDragon.getLoot());
        Assert.assertFalse(goldDragon.isDodging());
    }

    @Test
    public void testVampireExtendsCharacter(){
        Assert.assertTrue(goldDragon instanceof Creature);
    }

    @Test
    public void testClassImplementsCorrectInterfaces(){
        Assert.assertTrue(goldDragon instanceof Monster);
        Assert.assertTrue(goldDragon instanceof Dragon);
        Assert.assertTrue(goldDragon instanceof MagicCaster);
    }

    @Test
    public void testGoldDragonMakeSound(){
        Assert.assertEquals("groooow",skeleton.makeSound());
    }
}
