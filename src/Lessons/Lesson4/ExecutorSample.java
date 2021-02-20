package Lessons.Lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Пример ExecutorService
public class ExecutorSample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3);//Создает пул потоков с числом которое мы сам указываем
    executorService = Executors.newCachedThreadPool();//Создает пул потоков без верхнего предела, т.е. динамически раширяемый
    //опасен тем что оставляет в себе все потоки и может просто засрать память

    executorService = Executors.newSingleThreadExecutor();//Создается пул потоков из одного потока

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    //передаю в пулл объект класса Runnable
    executorService.execute(runnable);
    //при newSingleThreadExecutor() (пуле одном )
    executorService.execute(runnable);
    executorService.execute(runnable);

  }
}
