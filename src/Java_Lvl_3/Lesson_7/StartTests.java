package Java_Lvl_3.Lesson_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Map;
import java.util.TreeMap;

public class StartTests {
    public static void main(String[] args) {
      start(Tested1.class);
      start(Tested2.class);
      start(Tested3.class);
    }
    public static void start(Class c){
        Method[] methods = c.getDeclaredMethods();

        Map<Integer, Method> map = new TreeMap<>();

        for ( Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)){
                if (map.containsKey(0)) throw new RuntimeException("Метод Before уникален");
                map.put(0,method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)){
                if (map.containsKey(11)) throw new RuntimeException("Метод After уникален");
                map.put(11,method);
            }
            if (method.isAnnotationPresent(Test.class)){
                map.put(method.getAnnotation(Test.class).priority(),method);
            }
        }
        for ( Integer i : map.keySet()) {
            try {
                map.get(i).invoke(c.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
