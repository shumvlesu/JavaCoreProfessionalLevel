package Lessons.Lesson7;

public class Cat extends Animal implements Jumpable {
  private int quantitySleep; //время сна кошки

  public Cat(String name, int age, int quantitySleep) {
    super(name, age);
    this.quantitySleep = quantitySleep;
  }

  @Override
  public void jump() {
    System.out.println("Кошка прыгнула");
  }

  public int getQuantitySleep() {
    return quantitySleep;
  }
}