package Lessons.Lesson5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CountDownLatchSample2 {
  public static void main(String[] args) throws InterruptedException {

    int threadCount = 6;
    CountDownLatch countDownLatchSample = new CountDownLatch(threadCount);
    for (int i = 0; i < threadCount; i++) {
      final int w = i;
      new Thread(() -> {
        try {
          Thread.sleep(1000 + new Random().nextInt(2000));
          countDownLatchSample.countDown(); //поток выполнился
          System.out.println("Поток" + w + " закончил свое выполнение");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }

    //У await() есть перегруженный метод в таком виде countDownLatchSample.await(2, TimeUnit.SECONDS);
    // , т.е. если за 2 секунды не завершаться все потоки то await() вернет false

    boolean result = countDownLatchSample.await(2, TimeUnit.SECONDS);
    if (result) {
      System.out.println("Все потоки завершили свою работу");
    } else {
      System.out.println("Не все потоки успели завершить свою работу");
    }
    //Поток5 закончил свое выполнение
    //Поток1 закончил свое выполнение
    //Не все потоки успели завершить свою работу
    //Поток4 закончил свое выполнение
    //Поток3 закончил свое выполнение
    //Поток2 закончил свое выполнение
    //Поток0 закончил свое выполнение


  }
}
