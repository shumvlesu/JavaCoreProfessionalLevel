package Lessons.Lesson1;

public class SimpleBox<T> {
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
