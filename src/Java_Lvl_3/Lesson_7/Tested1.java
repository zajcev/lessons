package Java_Lvl_3.Lesson_7;

public class Tested1 {

    @BeforeSuite
    void before(){
        System.out.println("Before Test 1");
    }
    @AfterSuite
    public void after(){
        System.out.println("After Test 1");
    }
    @Test(priority = 7)
    public void one(){
        System.out.println("Third method Test 1");
    }
    @Test(priority = 6)
    public void two(){
        System.out.println("Second method Test 1");
    }
    @Test(priority = 5)
    public void three(){
        System.out.println("First method Test 1");
    }
}
