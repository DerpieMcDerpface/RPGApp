package model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.characteroptions.Undead;
import fr.sogeti.rpgapp.model.realcharacters.Vampire;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VampireTest {
    Creature target;
    Vampire vampire;

    @Before
    public void beforeEach() {
        target = Mockito.mock(Creature.class);
        Mockito.when(target.getLevel()).thenReturn(1);
        Mockito.when(target.getIntelligence()).thenReturn(10);
        //Vampire(health, level, [str, int, agi])
        vampire = new Vampire(100,10, new int[]{5, 5, 5});
    }

    @Test
    public void testDefaultConstructorValues() {
        Assert.assertEquals("Vampire", vampire.getName());
        Assert.assertEquals(250, vampire.getExpReward());
        Assert.assertEquals("Magic item", vampire.getLoot());
        Assert.assertFalse(vampire.isDodging());
    }

    @Test
    public void testVampireExtendsCharacter() {
        Assert.assertTrue(vampire instanceof Creature);
    }

    @Test
    public void testClassImplementsCorrectInterfaces() {
        Assert.assertTrue(vampire instanceof Monster);
        Assert.assertTrue(vampire instanceof Undead);
        Assert.assertTrue(vampire instanceof MagicCaster);
    }

    @Test
    public void testVampireSpell() {
        Mockito.when(target.getLevel()).thenReturn(1);
        Mockito.when(target.getIntelligence()).thenReturn(10);
        Mockito.when(target.getHealthPoints()).thenReturn(100);
        Vampire vampireSpy = Mockito.spy(vampire);

        int damageSupposedToBeDealt = (vampire.getLevel() * vampire.getIntelligence()) - (target.getLevel() + target.getIntelligence());
        int healAmount = damageSupposedToBeDealt / 2;

        vampireSpy.castSpell(target);
        Mockito.verify(target).takeDamage(damageSupposedToBeDealt);
        Mockito.verify(vampireSpy).heal(healAmount);
    }

    @Test
    public void testVampireSpellForLowHealthTarget() {
        Mockito.when(target.getLevel()).thenReturn(1);
        Mockito.when(target.getIntelligence()).thenReturn(10);
        Mockito.when(target.getHealthPoints()).thenReturn(10);
        Vampire vampireSpy = Mockito.spy(vampire);

        int damageSupposedToBeDealt = (vampire.getLevel() * vampire.getIntelligence()) - (target.getLevel() + target.getIntelligence());
        int cappedHealAmount = target.getHealthPoints();

        vampireSpy.castSpell(target);
        Mockito.verify(target).takeDamage(damageSupposedToBeDealt);
        Mockito.verify(vampireSpy).heal(cappedHealAmount);
    }

    @Test
    public void testVampireSpellForHighLevelTarget() {
        Mockito.when(target.getLevel()).thenReturn(1000);
        Mockito.when(target.getIntelligence()).thenReturn(1000);
        Mockito.when(target.getHealthPoints()).thenReturn(1000);
        Vampire vampireSpy = Mockito.spy(vampire);

        int minimumDamage = 2;
        int healAmount = 1;

        vampireSpy.castSpell(target);
        Mockito.verify(target).takeDamage(minimumDamage);
        Mockito.verify(vampireSpy).heal(healAmount);
    }


}










