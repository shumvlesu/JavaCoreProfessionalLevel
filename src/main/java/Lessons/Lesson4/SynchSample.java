package Lessons.Lesson4;

public class SynchSample {
  //Пример синхронизации потоков
  //Для синхронизации потоков используют методы:
  //wait(); - если меня вызвали то я помещаю текущий поток в wait-set объекта монитор
  //wait рекомендуется вызывать в цикле , так как оракл говорит о том что может сработать случайный notify и разбудить поток
  //Пример
  // while (!"Пока!".equalsIgnoreCase(currentString)) {
  //            wait();//усыпляем поток пор пока в currentString не окажется слова - Привет!
  // }


  //это значит что поток вызвавший метод wait() приостанавливает свое выполнение и снимает все свои блокировки (все что заблокировал)
  //notify(); - будит случайный поток из всего wait-set'а
  //notifyAll(); - будит все потоки из wait-set'а, но только один из разбужнеых успеет забрать блокировку
  //будить можно только случайные потоки
  //их можно вызывать только внутри синхронизированных блоков кода

  //потоки кэшируют переменные и что бы такого не было ставлю volatile
  private volatile String currentString = "Привет!";

  public static void main(String[] args) {
    SynchSample synchSample = new SynchSample();

    Thread thread1 = new Thread(() -> synchSample.method1());
    Thread thread2 = new Thread(() -> synchSample.method2());
    thread1.setName("Поток 1");
    thread2.setName("Поток 2");
    thread1.start();
    thread2.start();

  }

  public void method1() {
    try {
      synchronized (this) {
        for (int i = 0; i < 3; i++) {
          while (!"Привет!".equalsIgnoreCase(currentString)) {
            wait();//усыпляем поток пор пока в currentString не окажется слова - Привет!
          }
          printMessage("Привет!");
          currentString = "Пока!";
          notify();
        }

      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void method2() {
    try {
      synchronized (this) {
        for (int i = 0; i < 3; i++) {
          while (!"Пока!".equalsIgnoreCase(currentString)) {
            wait();//усыпляем поток пор пока в currentString не окажется слова - Привет!
          }
          printMessage("Пока!");
          currentString = "Привет!";
          notify();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void printMessage(String message) {
    System.out.println(Thread.currentThread().getName() + " : " + message);
  }


}
