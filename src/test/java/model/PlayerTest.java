package model;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.Player;
import fr.sogeti.rpgapp.model.characteroptions.CharacterClass;
import fr.sogeti.rpgapp.model.realcharacters.Vampire;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

    private Player player;
    private Vampire target;
    private Player playerRogue;
    private Player playerWizard;

    @Before
    public void beforeEach(){
        target = Mockito.mock(Vampire.class);
        player = new Player("John", 100,1,new int[]{10,5,5}, CharacterClass.FIGHTER);
        playerRogue = new Player("Kate", 50,1,new int[]{5,5,10}, CharacterClass.ROGUE);
        playerWizard = new Player("Kevin", 50,1,new int[]{5,10,5}, CharacterClass.WIZARD);
    }

    @Test
    public void testConstructorForEachCharacterClassOption(){
        Assert.assertEquals("Sword;Shield",player.getEquipement());
        Assert.assertEquals(CharacterClass.FIGHTER, player.getCharacterClass());

        Assert.assertEquals("Dagger",playerRogue.getEquipement());
        Assert.assertEquals(CharacterClass.ROGUE, playerRogue.getCharacterClass());

        Assert.assertEquals("Magic Staff",playerWizard.getEquipement());
        Assert.assertEquals(CharacterClass.WIZARD, playerWizard.getCharacterClass());
    }

    @Test
    public void testPlayerGain250Experience(){
        Mockito.when(target.getExpReward()).thenReturn(250);
        player.gainExperience(target.getExpReward());
        int expectedExp = 250;
        Assert.assertEquals(expectedExp,player.getExperience());
    }

    @Test
    public void testPlayerGain1500Experience(){
        Mockito.when(target.getExpReward()).thenReturn(1500);
        player.gainExperience(target.getExpReward());
        int expectedExp = 500;
        int expectedLevel = 2;
        Assert.assertEquals(expectedExp,player.getExperience());
        Assert.assertEquals(expectedLevel,player.getLevel());
    }

    @Test
    public void testPlayerGainNoLoot(){
        Mockito.when(target.getLoot()).thenReturn("None");
        player.gainLoot(target.getLoot());
        String expectedEquipement = "Sword;Shield";
        Assert.assertEquals(expectedEquipement,player.getEquipement());
    }

    @Test
    public void testPlayerGainALoot(){
        Mockito.when(target.getLoot()).thenReturn("Loot");
        player.gainLoot(target.getLoot());
        String expectedEquipement = "Sword;Shield;Loot";
        Assert.assertEquals(expectedEquipement,player.getEquipement());
    }

    @Test
    public void testPlayerFighterAttack(){
        int damageTaken=player.getStrength()*player.getLevel();
        player.attack(target);
        Mockito.verify(target).takeDamage(10);
    }

    @Test
    public void testPlayerRogueAttack(){
        int damageTaken=playerRogue.getAgility()*player.getLevel();
        playerRogue.attack(target);
        Mockito.verify(target).takeDamage(10);
    }

    @Test
    public void testPlayerWizardAttack(){
        int damageTaken=playerWizard.getIntelligence()*player.getLevel();
        playerWizard.attack(target);
        Mockito.verify(target).takeDamage(10);

    }
}
