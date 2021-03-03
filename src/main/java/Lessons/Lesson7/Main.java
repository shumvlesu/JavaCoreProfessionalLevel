package Lessons.Lesson7;

public class Main {
  //Рефлексия- когда объект изучает сам себя. Для джавы это механизм исследования данных о программе во время ее выполнения
  //механизм рефлексии позволяет обрабатывать типы, отсутствующие при компиляции, но появившиеся во время выполнения программы.
  //https://javarush.ru/groups/posts/513-reflection-api-refleksija-temnaja-storona-java
  public static void main(String[] args) throws ClassNotFoundException {
    //Class - базовый класс рефлексии? является метаклассом для всех классов в джаве
    // это значит что он содержит информацию о самой стркутуре класса (какие в нем поля, методы и т.д.)
    Cat cat = new Cat("Барсик", 4, 4);
    //3 способа получить экземпляра класса Class кошки
    Class catClass = Cat.class; //1й
    System.out.println(catClass.getName()); //Lessons.Lesson7.Cat
    catClass = Class.forName("Lessons.Lesson7.Cat");//2й
    System.out.println(catClass.getSimpleName()); //Cat
    catClass = cat.getClass();//3й


  }
}
