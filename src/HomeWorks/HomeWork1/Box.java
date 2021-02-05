package HomeWorks.HomeWork1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
  //коробка с фруктами
  private final List<T> fruits;

  public Box() {
    this.fruits =  new ArrayList<>();
  }

  public List<T> getFruitsBox() {
    return fruits;
  }

  //метод перекладывания из коробки в коробку
  public void shiftTo(Box <T>anotherBox){
    anotherBox.fruits.addAll(fruits);
    fruits.clear();
  }

  //считаем фрукты в ящике
  public float getWeightInBox(){
    float sum = 0;
    for (T fruit : fruits) {
      sum +=fruit.getWeight();
    }
    return sum;
  }

  //сравниваем ящики
  public boolean compare(Box o) {
    return 0.0 == Float.compare(this.getWeightInBox(), o.getWeightInBox());
  }

  //добавление фруктов
  public void addFruit(T fruit, int amount){
    for(int i=0;i<amount;i++){
      fruits.add(fruit);
    }
  }

}
