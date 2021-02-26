package Lessons.Lesson1;

//класс обертка , он же дженерик
public class SimpleBox3<T extends Number> {//T extends Number - так мы ограничиваем общем классом Number
  // и говорим что тип может быть только из числовых типов (Double, Long, Integer и т.д.)
  //еще один ньюанс мы наследуем тип от класса Number. Класс SimpleBox3 от Number ничего не наследует
  private T obj;

  public SimpleBox3(T obj) {
    this.obj = obj;
  }

  public T getObj() {
    return obj;
  }

  public void setObj(T obj) {
    this.obj = obj;
  }
}
