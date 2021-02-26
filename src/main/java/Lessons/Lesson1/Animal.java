package Lessons.Lesson1;

public class Animal {
  private final String name;
  private final int age;
  private final int products;

  public Animal(String name, int age, int products) {
    this.name = name;
    this.age = age;
    this.products = products;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getProducts() {
    return products;
  }
}
