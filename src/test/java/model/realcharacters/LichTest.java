package model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.MagicCaster;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.characteroptions.Undead;
import fr.sogeti.rpgapp.model.realcharacters.Lich;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LichTest {
    Creature targetNormal;
    Creature targetUndead;
    Lich lich;

    @Before
    public void beforeEach() {
        targetNormal = Mockito.mock(Creature.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(targetNormal.getLevel()).thenReturn(1);
        Mockito.when(targetNormal.getIntelligence()).thenReturn(10);
        int[] stats = {5, 5, 5};
        lich = new Lich("Arthas", 100, 10, stats, "Magic wand");
    }

    @Test
    public void testDefaultConstructorValues() {
        Assert.assertEquals("Arthas", lich.getName());
        Assert.assertEquals(5, lich.getHealthRegen());
        Assert.assertEquals(500, lich.getExpReward());
        Assert.assertEquals("Magic wand", lich.getLoot());
        Assert.assertFalse(lich.isDodging());
    }

    @Test
    public void testLichExtendsCharacter() {
        Assert.assertTrue(lich instanceof Creature);
    }

    @Test
    public void testClassImplementsCorrectInterfaces() {
        Assert.assertTrue(lich instanceof Monster);
        Assert.assertTrue(lich instanceof Undead);
        Assert.assertTrue(lich instanceof MagicCaster);
    }

    @Test
    public void testLichSpellOnUndead() {
        targetUndead = Mockito.mock(Creature.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(targetUndead.getLevel()).thenReturn(1);
        Mockito.when(targetUndead.getIntelligence()).thenReturn(10);
        Mockito.when(targetUndead.getHealthPoints()).thenReturn(100);

        int healAmount = (lich.getLevel() * lich.getIntelligence());

        lich.castSpell(targetUndead);
        Mockito.verify(targetUndead).heal(healAmount);
    }

    @Test
    public void testLichSpellOnTarget() {
        Mockito.when(targetNormal.getLevel()).thenReturn(1);
        Mockito.when(targetNormal.getIntelligence()).thenReturn(10);
        Mockito.when(targetNormal.getHealthPoints()).thenReturn(100);

        int damageSupposedToBeDealt = (lich.getLevel() * lich.getIntelligence()) - (targetNormal.getLevel() + targetNormal.getIntelligence());

        lich.castSpell(targetNormal);
        Mockito.verify(targetNormal).takeDamage(damageSupposedToBeDealt);
    }

    @Test
    public void testLichSpellForHighLevelTarget() {
        Mockito.when(targetNormal.getLevel()).thenReturn(1000);
        Mockito.when(targetNormal.getIntelligence()).thenReturn(10000);
        Mockito.when(targetNormal.getHealthPoints()).thenReturn(10000);

        int minimumDamage = 2;

        lich.castSpell(targetNormal);
        Mockito.verify(targetNormal).takeDamage(minimumDamage);
    }
}
