package Lessons.Lesson7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) //аннотация сохраняется и используется включительно во время компиляции приложения
//@Target(ElementType.FIELD)
@Target({ElementType.FIELD, ElementType.METHOD}) //говорим что аннотация используется для полей и методов
public @interface TimeUnit {
  String name() default "hour";
  String ruName();
  // можно вот так поля объявлять еще. берем значение из enum (перечисление)
  java.util.concurrent.TimeUnit myName() default java.util.concurrent.TimeUnit.HOURS;
}
