package Lessons.Lesson5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample {

  //Lock - интерфейс управления блокировкой объекта.
  //у интерфейса есть методы:
  //lock - вешаем блокировку на объект
  //tryLock - попытка заблокировать объект интерфейса, если объект заблокировал то возвращает true
  //имеет перегрузку - tryLock(long time, TimeUnit unit) если за какоето время поток не получил блокировку то возвращает false, получил - true
  //unlock - снимает блокировку с объекта
  public static void main(String[] args) {
    Lock lock = new ReentrantLock();

    for (int i = 0; i < 5; i++) {
      final int w = i;
      new Thread(() -> {
        System.out.println("Поток"+w+" остановился перед семафором");
        boolean result = false;
        try {
          Thread.sleep(3000);
          //блокируем объект
          //все что между lock() и unlock() считается синхронизированным кодом
          //lock.lock();

          result = lock.tryLock();
          if (result){
            System.out.println("Поток" + w + " занял семафор");
            Thread.sleep(5000);
          }else {
            System.out.println("Поток" + w + " не занял семафор");
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }finally {
          if(result) {
            System.out.println("Поток" + w + " освободил семафор");
            //разблокируем объект
            lock.unlock();
          }
        }
      }).start();
    }
    //Поток1 остановился перед семафором
    //Поток2 остановился перед семафором
    //Поток4 остановился перед семафором
    //Поток0 остановился перед семафором
    //Поток3 остановился перед семафором
    //Поток2 заблокировал семафор
    //Поток2 освободил семафор
    //Поток1 заблокировал семафор
    //Поток1 освободил семафор
    //Поток4 заблокировал семафор
    //Поток4 освободил семафор
    //Поток0 заблокировал семафор
    //Поток0 освободил семафор
    //Поток3 заблокировал семафор
    //Поток3 освободил семафор

  }
}
