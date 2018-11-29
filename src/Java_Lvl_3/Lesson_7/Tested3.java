package Java_Lvl_3.Lesson_7;

public class Tested3 {
    @BeforeSuite
    void before(){
        System.out.println("Before Test 3");
    }
    @AfterSuite
    public void after(){
        System.out.println("After Test 3");
    }
    @Test(priority = 4)
    public void one(){
        System.out.println("First method Test 3");
    }
    @Test(priority = 5)
    public void two(){
        System.out.println("Second method Test 3");
    }
    @Test(priority = 6)
    public void three(){
        System.out.println("Third method Test 3");
    }
}
