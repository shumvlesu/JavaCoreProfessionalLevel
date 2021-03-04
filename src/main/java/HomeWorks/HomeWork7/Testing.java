package HomeWorks.HomeWork7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Testing {
  public static void goTests(Class testSuite) throws IllegalAccessException, InvocationTargetException {

    ArrayList<Method> testMethods = new ArrayList<>();
    Method beforeMethod = null;
    Method afterMethod = null;
    Object obj = null;

    try {
      obj = testSuite.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }

    for (Method m : testSuite.getDeclaredMethods()) {
      if (m.isAnnotationPresent(Test.class)) {
        testMethods.add(m);
      } else if (m.isAnnotationPresent(BeforeSuite.class)) {
        if (beforeMethod == null) {
          beforeMethod = m;//нашли beforeSuite()
        } else {
          throw new RuntimeException("Должно быть не более одного метода с аннотацией @BeforeSuite");
        }
      }
      if (m.isAnnotationPresent(AfterSuite.class)) {
        if (afterMethod == null) {
          afterMethod = m;//нашли afterSuite()
        } else {
          throw new RuntimeException("Должно быть не более одного метода с аннотацией @AfterSuite");
        }
      }
    }

    //в начале beforeSuite()
    if (beforeMethod != null) {
      beforeMethod.invoke(obj);
    }

    //сортируем по приоритету и выполняем
    testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));
    for (Method m : testMethods) {
      m.invoke(obj);
    }

    //в конце afterSuite()
    if (afterMethod != null) {
      afterMethod.invoke(obj);
    }


  }
}
