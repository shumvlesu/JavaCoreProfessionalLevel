package Lessons.Lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainAnnotationPrimer {
  public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
    //пример работы с аннотацией , применяя рефлексию класса

    Cat myCat = new Cat("Барсик", 4, 4);
    Class catClass = Cat.class;
    Field field = catClass.getDeclaredField("quantitySleep");
    for (Annotation annotation : field.getAnnotations()) {
      System.out.println(annotation);
    }

    //получаю аннотацию по имени
    TimeUnit timeUnitForCat = field.getAnnotation(TimeUnit.class);
    //теперь мы можем получить значение поля name
    System.out.println(timeUnitForCat.name());
    System.out.println(timeUnitForCat.ruName());

    System.out.println();
    //тоже самое получаю значение полей аннотации метода
    Method quantityGetMethod = catClass.getDeclaredMethod("getQuantitySleep");
    TimeUnit timeUnitForMethod = quantityGetMethod.getAnnotation(TimeUnit.class);
    System.out.println(timeUnitForMethod.name());
    System.out.println(timeUnitForMethod.ruName());
    java.util.concurrent.TimeUnit unit = timeUnitForMethod.myName();
    System.out.println(unit);


    //field.setAccessible(true);

  }
}
