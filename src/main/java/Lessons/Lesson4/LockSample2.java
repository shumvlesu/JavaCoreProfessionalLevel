package Lessons.Lesson4;

//Пример монитора (мьютакса)
//Пример синхронизации через объект
public class LockSample2 {

  Object lock = new Object();

  public static void main(String[] args) {
    LockSample2 lockSample2 = new LockSample2();
    new Thread(() -> lockSample2.method1()).start();
    new Thread(() -> lockSample2.method1()).start();

//    new Thread(() -> lockSample2.method2()).start();

  }

  public void method1() {

    printMessage("Начало не сихрнизированного блока");
    try {
      printMessage("ИБД");
      Thread.sleep(3000);//спим 3 секунды
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    printMessage("Конец не сихрнизированного блока");

    //синхронизация по объекту
    //когда объект lockSample2 войдет в метод method1 он не навесит блокировку на lockSample2
    //он заблокирует объект lock
    synchronized (lock) {
      printMessage("Начало сихрнизированного блока");
      for (int i = 0; i < 3; i++) {
        printMessage("Привет!");
      }
      printMessage("Конец сихрнизированного блока");
    }
  }

//  public void method2() {
//    for (int i = 0; i < 3; i++) {
//      printMessage("Пока!");
//    }
//  }




  public void printMessage(String message) {
    System.out.println(Thread.currentThread().getName() + " : " + message);
  }

}
