package Lessons.Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Corral<T extends Animal> {
 private List<T> animals;

  public Corral() {
    this.animals = new ArrayList<>();
  }

  public void addAnimal(T animal){
   animals.add(animal);
 }

  public List<T> getAnimals() {
    return animals;
  }
}
