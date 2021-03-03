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
    Method quantityGetMethod = catClass.getDeclaredMethod("getQuantitySleep");// getMethod() аналгичен getMethods()
    System.out.println(quantityGetMethod.getName());
    quantityGetMethod.setAccessible(true);//усатновление права вызова этого метода из метода main
    //выполняем метод
    System.out.println(quantityGetMethod.invoke(myCat));


    Method quantitySetMethod = catClass.getDeclaredMethod("setQuantitySleep", int.class);//если у метода есть аргументы то надо тоже указать их, иначе их не найдем
    quantitySetMethod.setAccessible(true);
    quantitySetMethod.invoke(myCat,20);//устанавливаю значение
    //смотрю что получилось
    System.out.println(quantityGetMethod.invoke(myCat));

  }
}
