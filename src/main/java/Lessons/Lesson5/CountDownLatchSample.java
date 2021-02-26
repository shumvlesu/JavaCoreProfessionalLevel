package Lessons.Lesson5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;


//CountDownLatch можно использовать когда надо отследить чтобы все потоки отработали и к определенной черте (await()) они подошли все выполненные.
public class CountDownLatchSample {
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
    countDownLatchSample.await();//отслеживает завершение всех 6 потоков, пока countDown() не станет 0
    //У await() есть перегруженный метод в таком виде countDownLatchSample.await(2, TimeUnit.SECONDS);
    // , т.е. если за 2 секунды не завершаться все потоки то await() вернет false

    System.out.println("Все потоки завершили свою работу");
  }
}
