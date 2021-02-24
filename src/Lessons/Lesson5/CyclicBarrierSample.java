package Lessons.Lesson5;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//Если CountDownLatch (как основной поток) один ждет все потоки пока они выполнятся, то в CyclicBarrier все потоки ждут всех.
public class CyclicBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);//4 - это сколько ждать потоков
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(3);//3 - это сколько ждать потоков
        for (int i = 0; i < 4; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Поток" + w + " начинает подготовку");
                    Thread.sleep(1000 + new Random().nextInt(2000));
                    System.out.println("Поток" + w + " готов");
                    cyclicBarrier.await();//в этой точке сойдутся все потоки
                    System.out.println("Поток" + w + " дождался остальных");


                    Thread.sleep(1000 + new Random().nextInt(2000));
                    System.out.println("Поток" + w + " снова ждет остальных");
                    //cyclicBarrier.await();//2я точка где сойдутся все потоки
                    cyclicBarrier2.await();//у cyclicBarrier2 ожидание 3 потоков а cyclicBarrier1 ихзадали 4
                    //так 4 поток будет висеть на cyclicBarrier2.await() так как на него не прийдет следующий вызов пачки из 3 потоков
                    //программа будет висеть из за ожидающегоо 4го потока, см внизу результат, Поток1.


                    System.out.println("Поток" + w + " снова дождался остальных");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        //Поток1 начинает подготовку
        //Поток2 начинает подготовку
        //Поток3 начинает подготовку
        //Поток0 начинает подготовку
        //Поток2 готов
        //Поток0 готов
        //Поток1 готов
        //Поток3 готов
        //Поток2 дождался остальных
        //Поток1 дождался остальных
        //Поток0 дождался остальных
        //Поток3 дождался остальных
        //Поток2 снова ждет остальных
        //Поток3 снова ждет остальных
        //Поток0 снова ждет остальных
        //Поток2 снова дождался остальных
        //Поток0 снова дождался остальных
        //Поток3 снова дождался остальных
        //Поток1 снова ждет остальных
    }
}
