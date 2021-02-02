package Lessons.Lesson1;

//Урок 1. Обобщения
public class Main {
  public static void main(String[] args) {
    SimpleBox simpleBox = new SimpleBox(20);
    SimpleBox simpleBox1 = new SimpleBox(50);

    //Оператор instanceof нужен, чтобы проверить, был ли объект, на который ссылается переменная X, создан на основе какого-либо класса Y.
    //Проверяем что у нас в simpleBox и simpleBox1 лежат переменные класса Integer
    if (simpleBox.getObj() instanceof Integer && simpleBox1.getObj() instanceof Integer){
      int sum = (Integer)simpleBox.getObj()+(Integer)simpleBox1.getObj();
      System.out.printf("Сумма чисел: %d\n",sum);
    }else {
      System.out.println("Не можем произвести приведение типов!");
    }

  }
}
