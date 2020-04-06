package model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Dragon;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.realcharacters.RedDragon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RedDragonTest {
    Creature target;
    Creature otherTarget;
    RedDragon redDragon;

    @Before
    public void beforeEach() {
        target = Mockito.mock(Creature.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(target.getLevel()).thenReturn(1);
        Mockito.when(target.getIntelligence()).thenReturn(10);
        int[] stats = {5, 5, 5};
       // redDragon = new RedDragon("Red Dragon", )
    }

    @Test
    public void testDefaultConstructorValues() {
        Assert.assertEquals("Red Dragon", redDragon.getName());
        Assert.assertEquals(500, redDragon.getExpReward());
        Assert.assertEquals("Huge amount of gold KEKW", redDragon.getLoot());
        Assert.assertFalse(redDragon.isDodging());
    }

    @Test
    public void testLichExtendsCharacter() {
        Assert.assertTrue(redDragon instanceof Creature);
    }

    @Test
    public void testClassImplementsCorrectInterfaces() {
        Assert.assertTrue(redDragon instanceof Monster);
        Assert.assertTrue(redDragon instanceof Dragon);
    }

    @Test
    public void testRedDragonBreathOnMonsters() {
        otherTarget = Mockito.mock(Creature.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(otherTarget.getLevel()).thenReturn(1);
        Mockito.when(otherTarget.getIntelligence()).thenReturn(10);
        Mockito.when(otherTarget.getHealthPoints()).thenReturn(100);

        //I suppose this breath is clearly broken, but better nerf Irelia ¯\_(ツ)_/¯
        int damageSupposedToBeDealt = (redDragon.getLevel() * redDragon.getIntelligence());

        redDragon.breath();
        Mockito.verify(target).takeDamage(damageSupposedToBeDealt);
        Mockito.verify(otherTarget).takeDamage(damageSupposedToBeDealt);
    }

}
