package Lessons.Lesson1;

//класс обертка , он же дженерик
public class SimpleBox2<T,U> {//можно искпользовать несколько типов

  private T obj;
  private U obj2;

  public SimpleBox2(T obj,U obj2) {
    this.obj = obj;
    this.obj2 = obj2;
  }

  public T getObj() {
    return obj;
  }

  public void setObj(T obj) {
    this.obj = obj;
  }

  public U getObj2() {
    return obj2;
  }

  public void setObj2(U obj2) {
    this.obj2 = obj2;
  }
}
