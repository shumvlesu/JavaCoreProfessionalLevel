package Lessons.Lesson7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main4 {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    Cat myCat = new Cat("Барсик", 4, 4);
    Class catClass = Cat.class;
    //доступ к модификаторам класса. Через класс Modifier описываются все модификаторы
    //и можно узнать какой у нас класс
    System.out.println(Modifier.isFinal(catClass.getModifiers())); //класс final?
    System.out.println(Modifier.isStatic(catClass.getModifiers()));//класс static?
    System.out.println(Modifier.isAbstract(catClass.getModifiers()));//класс abstract?
    System.out.println(Modifier.isPublic(catClass.getModifiers()));//класс public?

    System.out.println();
    //а теперь с методом
    for (Method declaredMethod : catClass.getDeclaredMethods()) {
      System.out.println(declaredMethod.getName() +" "+ Modifier.isPublic(declaredMethod.getModifiers()));//метод public?
    }


    System.out.println();
    //а теперь с полями класса
    //getFields - только не с приватными полями
    //getDeclaredFields() - со скрытыми
    for (Field field : catClass.getDeclaredFields()) {
      System.out.println(field.getName());
    }

    System.out.println();
    //получим поле по имени и поменяем его
    Field field = catClass.getDeclaredField("quantitySleep");
    field.setAccessible(true);
    System.out.println(myCat.getQuantitySleep2());
    field.set(myCat,5);
    System.out.println(myCat.getQuantitySleep2());

    
  }
}
