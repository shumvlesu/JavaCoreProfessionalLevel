package HomeWorks.HomeWork5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
  private final Semaphore semaphore;
  public Tunnel() {
    this.length = 80;
    this.description = "Тоннель " + length + " метров";
    //семафорим количество вьезжающих машин, по условию вместимость тоннеля должна быть в половину от общего числа машин.
    this.semaphore = new Semaphore(MainClass.CARS_COUNT / 2);
  }

  @Override
  public void go(Car c) {
    try {
      try {
        System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
        //ждем наполнения очереди заезда в тоннель
        semaphore.acquire();
        System.out.println(c.getName() + " начал этап: " + description);
        Thread.sleep(length / c.getSpeed() * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println(c.getName() + " закончил этап: " + description);
        //отпускаем машину из тоннеля
        semaphore.release();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}