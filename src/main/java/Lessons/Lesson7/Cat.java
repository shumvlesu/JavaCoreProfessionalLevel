package Lessons.Lesson7;

public class Cat extends Animal implements Jumpable {

  @TimeUnit(name = "seconds", ruName = "секунды") //используем нашу аннотацию. можем изменить на наше значение объявленого в аннотации поля name
  private int quantitySleep; //время сна кошки

  public Cat(String name, int age, int quantitySleep) {
    super(name, age);
    this.quantitySleep = quantitySleep;
  }

  @Override
  public void jump() {
    System.out.println("Кошка прыгнула");
  }

  @TimeUnit(ruName = "час")
  private int getQuantitySleep() {
    return quantitySleep;
  }

  @TimeUnit(ruName = "час")
  public int getQuantitySleep2() {
    return quantitySleep;
  }


  public void setQuantitySleep(int quantitySleep) {
    this.quantitySleep = quantitySleep;
  }
}
