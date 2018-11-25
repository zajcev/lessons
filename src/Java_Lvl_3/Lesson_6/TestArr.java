package Java_Lvl_3.Lesson_6;

import org.junit.Assert;
import org.junit.Test;

public class TestArr {
    private Lesson_6_Lvl_3 lesson;

    @Test
    public void testAfterFour1(){
        lesson = new Lesson_6_Lvl_3();
        int[] test = {1,2,3,5,6,7,4,1,2};
        int[] result = {1,2};
        Assert.assertArrayEquals(result,lesson.afterFour(test));
    }
    @Test
    public void testAfterFour2(){
        lesson = new Lesson_6_Lvl_3();
        int[] test = {1,2,3,4,6,7,2,1,2};
        int[] result = {6,7,2,1,2};
        Assert.assertArrayEquals(result,lesson.afterFour(test));
    }
    @Test
    public void testAfterFour3(){
        lesson = new Lesson_6_Lvl_3();
        int[] test = {2,3,5,6,7,1,1,2};
        int[] result = {};
        Assert.assertArrayEquals(result,lesson.afterFour(test));
    }
    @Test
    public void testAfterFour4(){
        lesson = new Lesson_6_Lvl_3();
        int[] test = {};
        int[] result = {};
        Assert.assertArrayEquals(result,lesson.afterFour(test));
    }
    @Test
    public void testOneAndFour1(){
        lesson = new Lesson_6_Lvl_3();
        int[] test = {1,2,3,5,6,7,4,1,2};
        Assert.assertTrue(lesson.oneAndFour(test));
    }
    @Test
    public void testOneAndFour2(){
        lesson = new Lesson_6_Lvl_3();
        int[] test = {1,2,3,5,6,7,1,1,2};
        Assert.assertFalse(lesson.oneAndFour(test));
    }
    @Test
    public void testOneAndFour3(){
        lesson = new Lesson_6_Lvl_3();
        int[] test = {2,2,2,2,2,4,6,6,6,6,6,1};
        Assert.assertTrue(lesson.oneAndFour(test));
    }
}
