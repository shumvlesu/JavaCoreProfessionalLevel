package Lessons.Lesson7;

import java.lang.reflect.Constructor;

public class Main2 {
  public static void main(String[] args) throws ClassNotFoundException {
    Cat cat = new Cat("Барсик", 4, 4);
    //дженерик класса Class
    //catClass = (Class<Cat>) Class.forName("Lessons.Lesson7.Cat"); //2
    //catClass = (Class<Cat>) cat.getClass();//3

    //дженерик класса Class
    Class<Cat> catClass = Cat.class;//1
    //из экземпляра класса Class мы можем получить все конструкторы (в данном случае все конструкторы класса Cat)
    for (Constructor<?> constructor : catClass.getConstructors()) {
      System.out.println(constructor); //public Lessons.Lesson7.Cat(java.lang.String,int,int)
    }


  }
}
