package HomeWorks.HomeWork5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
  public static final int CARS_COUNT = 4;
  public static CountDownLatch countDownLatch;
  public static volatile boolean winner = false;

  public static void main(String[] args)  {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    Race race = new Race(new Road(60), new Tunnel(), new Road(40));
    Car[] cars = new Car[CARS_COUNT];

    CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    countDownLatch = new CountDownLatch(CARS_COUNT);
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 20 + (int) (Math.random() * 10),cyclicBarrier);
    }

    for (int i = 0; i < cars.length; i++) {
      new Thread(cars[i]).start();
    }

    try {
      //Дожидаемся пока все машины не будут готовы к гонке
      countDownLatch.await();
      System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

      //++Дожидаемся пока все машины не достигнут финиша
      countDownLatch = new CountDownLatch(CARS_COUNT);
      countDownLatch.await();
      //--
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
  }
}












