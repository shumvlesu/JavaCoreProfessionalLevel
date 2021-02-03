package Lessons.Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Corral<T extends Animal> implements Comparable<Corral> {
 private List<T> animals;

  public Corral() {
    this.animals = new ArrayList<>();
  }

  public void addAnimal(T animal){
   animals.add(animal);
 }


 //пример использования дженерика в методах
 // причем использовать дженерики в статичеких методах мы можем
 public static <U> U getSomthing(U arg){
    return arg;
 }

  public List<T> getAnimals() {
    return animals;
  }

  public int getAllProducts(){
    int sum = 0;
    for (T animal : animals) {
      sum +=animal.getProducts();
    }
    return sum;
  }

  @Override
  public int compareTo(Corral t) {
    return Integer.compare(this.getAllProducts(), t.getAllProducts());
  }

}
