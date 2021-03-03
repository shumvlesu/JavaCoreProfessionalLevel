package Lessons.Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main3 {
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Cat myCat = new Cat("Барсик", 4, 4);
    Class catClass = Cat.class;
    //благодаря рефлексии мы можем получить описание супер класса класса
    System.out.println(catClass.getSuperclass());
    System.out.println();
    //можно узнать какие интерфейсы у класса
    for (Class anInterface : catClass.getInterfaces()) {
      System.out.println(anInterface.getName());
    }
    System.out.println();
    //можем получить доступ методам класса
    //catClass.getMethods();//вернет только лишь публичные методы класса Cat и его родителей.
    for (Method method : catClass.getMethods()) {
      System.out.println(method.getName());
    }

    System.out.println();
    //catClass.getDeclaredMethods();//вернет все методы вплоть до приватных класса Cat.
    for (Method declaredMethod : catClass.getDeclaredMethods()) {
      System.out.println(declaredMethod.getName());
    }


    System.out.println();
    Method quantityMethod = catClass.getDeclaredMethod("getQuantitySleep");// getMethod() аналгичен getMethods()
    System.out.println(quantityMethod.getName());
    quantityMethod.setAccessible(true);//усатновление права вызова этого метода из метода main
    //выполняем метод
    System.out.println(quantityMethod.invoke(myCat));


  }
}
