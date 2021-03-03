package Lessons.Lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main2 {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
    Cat myCat = new Cat("Барсик", 4, 4);
    //дженерик класса Class
    //catClass = (Class<Cat>) Class.forName("Lessons.Lesson7.Cat"); //2
    //catClass = (Class<Cat>) cat.getClass();//3

    //дженерик класса Class
    Class<Cat> catClass = Cat.class;//1
    //из экземпляра класса Class мы можем получить все конструкторы (в данном случае все конструкторы класса Cat)
    for (Constructor<?> constructor : catClass.getConstructors()) {
      System.out.println(constructor); //public Lessons.Lesson7.Cat(java.lang.String,int,int)
      //Мы создаем объект не напрямую а через экземпляр класса Class
      Cat cat = (Cat) constructor.newInstance("Васька", 3, 10);//аналогичное 7 строке создание конструткором объекта Cat
      System.out.println(cat.getName());
    }
    //возвращает конструктор по параметрам
    Constructor<Cat> constructor = catClass.getConstructor(String.class, int.class, int.class);
    Cat cat = constructor.newInstance("Васька", 3, 10);//теперь нам не нужно явное преведение типов в отличие отт стр 19
    System.out.println(cat.getName());
  }
}
