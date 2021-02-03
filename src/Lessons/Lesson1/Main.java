package Lessons.Lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Урок 1. Обобщения (дженерики)
public class Main<U> {
  //Для статических членов класса обобщение не работает
  //static U obj;
  U obj; //а так работает

  public static void main(String[] args) {
    SimpleBox<Integer> simpleBox = new SimpleBox<>(20);
    SimpleBox<Integer> simpleBox1 = new SimpleBox<>(50);

    //Оператор instanceof нужен, чтобы проверить, был ли объект, на который ссылается переменная X, создан на основе какого-либо класса Y.
    //Проверяем что у нас в simpleBox и simpleBox1 лежат переменные класса Integer
    // if (simpleBox.getObj() instanceof Integer && simpleBox1.getObj() instanceof Integer){
    // int sum = (Integer)simpleBox.getObj()+(Integer)simpleBox1.getObj();
    int sum = simpleBox.getObj() + simpleBox1.getObj();
    System.out.printf("Сумма чисел: %d\n", sum);
//    }else {
//      System.out.println("Не можем произвести приведение типов!");
//    }

    //пример использования дженерика с разными типами класса SimpleBox
    SimpleBox<String> simpleBoxS = new SimpleBox<>("Москва");//строка

    //SimpleBox<int> так будет ошибка, можно указывать только ссылочные типы, Integer как альтернатива.
    SimpleBox<Integer> simpleBoxI = new SimpleBox<>(80);//число
    concatenateString(simpleBoxS ,simpleBoxI );


    System.out.println();
    //дженерик с 2я типами
    SimpleBox2<Integer,String> simpleBoxIS = new SimpleBox2<>(80,"ddd");//число и строка
    //Смотрим какие типы у переменных
    System.out.println(simpleBoxIS.getObj().getClass().getName());
    System.out.println(simpleBoxIS.getObj2().getClass().getName());


    System.out.println();
    //3й пример, с коллекциями
    List<SimpleBox<? extends Number>> simpleBoxes = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      simpleBoxes.add(new SimpleBox<>(i*10));
    }
    System.out.println("Среднее арифметическое ="+average(simpleBoxes));


    System.out.println();
    //4й пример с коровками и овечками
    Corral<Cow> cows = new Corral<>();
    Corral<Sheep> sheeps = new Corral<>();
    for (int i = 0; i < 5; i++) {
      cows.addAnimal(new Cow(Integer.toString(i),i,new Random().nextInt(10)));
      sheeps.addAnimal(new Sheep(Integer.toString(i),i,new Random().nextInt(10)));
    }

  }

  private static double average(List<SimpleBox<? extends Number>> simpleBoxes){ //? extends Number - позволяет нам не делать перегрузку метода
    //для каждого числового типа (Byte, Integer, Long и т.д.) а наследоваться от общего числового класса Number
    double sum = 0;
    for (SimpleBox<? extends Number> simpleBox : simpleBoxes) {
      sum+=simpleBox.getObj().doubleValue(); //doubleValue() - приводим число к представлению типа double
    }
    return sum/simpleBoxes.size();
  }

  private static void concatenateString(SimpleBox<String> simpleBox,SimpleBox<Integer> simpleBox1) {
    System.out.println(simpleBox.getObj() +" "+ simpleBox1.getObj().toString());
  }

}
