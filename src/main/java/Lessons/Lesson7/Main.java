package Lessons.Lesson7;

public class Main {
  //Рефлексия- когда объект изучает сам себя. Для джавы это механизм исследования данных о программе во время ее выполнения
  public static void main(String[] args) throws ClassNotFoundException {
    //Class - базовый класс рефлексии? является метаклассом для всех классов в джаве
    // это значит что он содержит информацию о самой стркутуре класса (какие в нем поля, методы и т.д.)
    Cat cat = new Cat("Барсик", 4, 4);
    //3 способа получить экземпляра класса класс кошки
    Class catClass = Cat.class; //1й
    catClass = Class.forName("Lessons.Lesson7.Cat");//2й
    catClass = cat.getClass();//3й


  }
}
