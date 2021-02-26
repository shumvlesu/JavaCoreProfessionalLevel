package Lessons.Lesson1;

//класс обертка , он же дженерик
public class SimpleBox<T> {//<T> - тут мы можем указывать какую угодно букву или слово,
  // можем класс Object указать но так лучше не делать, это может привести к ошибкам в коде

  private T obj;

  public SimpleBox(T obj) {
    this.obj = obj;
  }

  public T getObj() {
    return obj;
  }

  public void setObj(T obj) {
    this.obj = obj;
  }
}
