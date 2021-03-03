package Lessons.Lesson7;

public class Cat extends Animal implements Jumpable {

  @TimeUnit(name = "минуты") //используем нашу аннотацию. можем изменить на наше значение объявленого в аннотации поля name
  private int quantitySleep; //время сна кошки

  public Cat(String name, int age, int quantitySleep) {
    super(name, age);
    this.quantitySleep = quantitySleep;
  }

  @Override
  public void jump() {
    System.out.println("Кошка прыгнула");
  }

  private int getQuantitySleep() {
    return quantitySleep;
  }

  public int getQuantitySleep2() {
    return quantitySleep;
  }


  public void setQuantitySleep(int quantitySleep) {
    this.quantitySleep = quantitySleep;
  }
}
