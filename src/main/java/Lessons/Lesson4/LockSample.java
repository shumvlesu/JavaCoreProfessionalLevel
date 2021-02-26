package Lessons.Lesson4;

//Пример монитора (мьютакса)
//Пример синхронизации через методы
public class LockSample {
  public static void main(String[] args) {
    LockSample monitor = new LockSample();
    new Thread(() -> monitor.method1()).start(); //объект monitor заблокирован потоком method1. Пока он не выполниться method2 не начнет работу.
    // method2 видит что method1 synchronized (синхранизированный) и будет ждать пока method1 не выполниться. это работает при условии что method2
    //тоже synchronized
    new Thread(() -> monitor.method2()).start();
    //будет так
    //Thread-0 : Привет!
    //Thread-0 : Привет!
    //Thread-0 : Привет!
    //Thread-1 : Пока!
    //Thread-1 : Пока!
    //Thread-1 : Пока!
  }

  //synchronized можно применить как на уровне метода так и на уровне объекта
  public synchronized void method1() {
    for (int i = 0; i < 3; i++) {
      printMessage("Привет!");
    }
  }

  //методы method2() и method3() идентичны по своей блокеровке
  // понятно что method2 удобнее писать чем method3
  public synchronized void method2() {
    for (int i = 0; i < 3; i++) {
      printMessage("Пока!");
    }
  }


  public void method3() {
    synchronized (this) {
      for (int i = 0; i < 3; i++) {
        printMessage("Пока!");
      }
    }
  }

  public void printMessage(String message) {
    System.out.println(Thread.currentThread().getName() + " : " + message);
  }

}
