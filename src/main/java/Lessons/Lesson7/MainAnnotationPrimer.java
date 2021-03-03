package Lessons.Lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MainAnnotationPrimer {
  public static void main(String[] args) throws NoSuchFieldException {
    //пример работы с аннотацией , применяя рефлексию класса

    Cat myCat = new Cat("Барсик", 4, 4);
    Class catClass = Cat.class;
    Field field = catClass.getDeclaredField("quantitySleep");
    for (Annotation annotation : field.getAnnotations()) {
      
    }
        
    field.setAccessible(true);

  }
}
