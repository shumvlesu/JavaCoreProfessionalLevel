package HomeWorks.HomeWork1;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    String[] arrayStr = {"A","B","C"};
    Integer[] arrayInt = {1,2,3};
    //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    exchangeOfElements(arrayStr, 0, 2);
    exchangeOfElements(arrayInt, 2, 1);
    //2. Написать метод, который преобразует массив в ArrayList;
    //пример со строковым массивом
    System.out.println();
    List<String> stringList = arrayToArrayList(arrayStr);
    System.out.println(stringList);
    System.out.println(stringList.get(0) instanceof String);
    //пример с числовым массивом
    List<Integer> stringList2 = arrayToArrayList(arrayInt);
    System.out.println(stringList2);
    System.out.println(stringList2.get(0) instanceof Integer);

    //3. Задача:
    //Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;+
    //Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    //Для хранения фруктов внутри коробки можно использовать ArrayList;

    //Сделать метод getWeight(), который высчитывает вес коробки,
    //зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

    //Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
    //которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
    // Можно сравнивать коробки с яблоками и апельсинами;

    //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    //Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    //Соответственно, в текущей коробке фруктов не остается,
    //а в другую перекидываются объекты, которые были в первой;

    //Не забываем про метод добавления фрукта в коробку.
    System.out.println();
    Box<Apple> appleBox = new Box<>(); //коробка для яблок
    Box<Orange> orangeBox = new Box<>();//коробка для апельсинов
    orangeBox.addFruit(new Orange(), 1); //закинем 1 апельсин
    appleBox.addFruit(new Apple(), 3); //закинем 3 яблока
    System.out.printf("Коробки по весу %s\n", appleBox.compare(orangeBox) ? "равны": "не равны");
    orangeBox.addFruit(new Orange(), 1); //докинем 1 апельсин
    //снова сверим ящики
    System.out.printf("Коробки по весу %s\n", appleBox.compare(orangeBox) ? "равны": "не равны");


    //перекидываем в пустую коробку
    System.out.println();
    Box<Orange> orangeBoxEmpty = new Box<>();//коробка для апельсинов, сейчас пустая
    System.out.println("Полная коробка содержит: "+orangeBox.getFruitsBox().size());
    System.out.println("Пустая коробка содержит: "+orangeBoxEmpty.getFruitsBox().size());
    //перекидываем
    orangeBox.shiftTo(orangeBoxEmpty);
    System.out.println("Теперь полная коробка содержит: "+orangeBox.getFruitsBox().size());
    System.out.println("Теперь бывшая пустой коробка содержит: "+orangeBoxEmpty.getFruitsBox().size());

    //а вот яблоки уже не даст в апельсиновую коробку закинуть
    //компилятор будет ругаться
    //appleBox.shiftTo(orangeBox);


  }

  //Метод который меняет два элемента массива местами
  private static <T> void exchangeOfElements(T[] array, int aPosition, int bPosition) {
    System.out.printf("Массив до обмена: %s\n",Arrays.toString(array));
    T buffer = array[aPosition];
    array[aPosition]=array[bPosition];
    array[bPosition]=buffer;
    System.out.printf("Массив после обмена: %s\n",Arrays.toString(array));
  }

  //Метод который преобразует массив в ArrayList
  private static <T> List<T> arrayToArrayList(T[] array) {
    List<T> list = new ArrayList<>();
    Collections.addAll(list, array);
    return list;
  }

}
