package model.realcharacters;

import fr.sogeti.rpgapp.model.Creature;
import fr.sogeti.rpgapp.model.characteroptions.Monster;
import fr.sogeti.rpgapp.model.characteroptions.Undead;
import fr.sogeti.rpgapp.model.realcharacters.Skeleton;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SkeletonTest {
    Creature target;
    Skeleton skeleton;

    @Before
    public void beforeEach(){
        target = Mockito.mock(Creature.class);
        Mockito.when(target.getLevel()).thenReturn(1);
        Mockito.when(target.getIntelligence()).thenReturn(10);
        Mockito.when(target.getHealthPoints()).thenReturn(100);
        skeleton = new Skeleton(1, 1, new int[]{2,1,1});
    }

    @Test
    public void testDefaultConstructorValues(){
        Assert.assertEquals("Skeleton",skeleton.getName());
        Assert.assertEquals(5, skeleton.getExpReward());
        Assert.assertEquals("No loot",skeleton.getLoot());
        Assert.assertFalse(skeleton.isDodging());
    }

    @Test
    public void testSkeletonExtendsCharacter(){
        Assert.assertTrue(skeleton instanceof Creature);
    }

    @Test
    public void testClassImplementsCorrectInterfaces(){
        Assert.assertTrue(skeleton instanceof Monster);
        Assert.assertTrue(skeleton instanceof Undead);
    }

    @Test
    public void testSkeletonMakeSound(){
        Assert.assertEquals("Doot doot !",skeleton.makeSound());
    }
}
