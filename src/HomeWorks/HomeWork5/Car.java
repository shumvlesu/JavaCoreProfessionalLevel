package HomeWorks.HomeWork5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
  private static int CARS_COUNT;

  static {
    CARS_COUNT = 0;
  }

  private Race race;
  private int speed;
  private String name;
  private CyclicBarrier cyclicBarrier;


  public String getName() {
    return name;
  }

  public int getSpeed() {
    return speed;
  }

  public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
    this.race = race;
    this.speed = speed;
    CARS_COUNT++;
    this.name = "Участник #" + CARS_COUNT;
    this.cyclicBarrier = cyclicBarrier;
  }

  @Override
  public void run() {
    try {
      System.out.println(this.name + " готовится");
      cyclicBarrier.await();
      Thread.sleep(500 + (int) (Math.random() * 800));
      System.out.println(this.name + " готов");
      cyclicBarrier.await();
    } catch (Exception e) {
      e.printStackTrace();
    }
    MainClass.countDownLatch.countDown();
    for (int i = 0; i < race.getStages().size(); i++) {
      race.getStages().get(i).go(this);
    }
    //Определяем победителя флажком
    if (!MainClass.winner){
      MainClass.winner = true;
      System.out.println(name + " " + "- WIN!");
    }
    MainClass.countDownLatch.countDown();
  }
}
