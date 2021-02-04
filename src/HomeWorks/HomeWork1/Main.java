package HomeWorks.HomeWork1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
//1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

//2. Написать метод, который преобразует массив в ArrayList;
    String[] arrayStr = {"A","B","C"};
    List<String> stringList = arrayToArrayList(arrayStr);
    System.out.println(stringList);
    System.out.println(stringList.get(0) instanceof String);

    Integer[] arrayInt = {1,2,3};
    List<Integer> stringList2 = arrayToArrayList(arrayInt);
    System.out.println(stringList2);
    System.out.println(stringList2.get(0) instanceof Integer);

//3. Задача:
//Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//Для хранения фруктов внутри коробки можно использовать ArrayList;
//Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
//Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
//Не забываем про метод добавления фрукта в коробку.

  }

  //Метод который преобразует массив в ArrayList
  private static <T> List<T> arrayToArrayList(T[] array) {
    List<T> list = new ArrayList<T>();
    Collections.addAll(list, array);
    return list;
  }

}
