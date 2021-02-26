package Lessons.Lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Пример, ExecutorService - это средство для запусков потоков.
public class ExecutorSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);//Создает пул потоков с числом которое мы сам указываем
        executorService = Executors.newCachedThreadPool();//Создает пул потоков без верхнего предела, т.е. динамически раширяемый
        //опасен тем что оставляет в себе все потоки и может просто засрать память

        executorService = Executors.newSingleThreadExecutor();//Создается пул потоков из одного потока

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                //System.out.println(Thread.currentThread().getName());
                System.out.println("Поток1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                //System.out.println(Thread.currentThread().getName());
                System.out.println("Поток2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                //System.out.println(Thread.currentThread().getName());
                System.out.println("Поток3");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //передаю в пулл объект класса Runnable
        executorService.execute(runnable1);
        //при newSingleThreadExecutor() (пуле c возможностью выполнения только одного потока) они будут выполняться поочередно
        executorService.execute(runnable2);
        executorService.execute(runnable3);


        //Пример с произвольным количеством  выполняемых потоков
        //чтобы попробовать закоментить сверху прмимер синглового выполнения
        //executorService = Executors.newFixedThreadPool(2);//разрешаю только 2 одновременных потока
        //executorService.execute(runnable1);
        //executorService.execute(runnable2);
        //executorService.execute(runnable3);


        //Чтобы завершить работу executorService и прошрамма завершилась
        // в этот момент executorService перестанет принимать на выполнение новые потоки, выполняет оставшиеся работающие
        //и завершает работу
        executorService.shutdown();
        executorService.shutdownNow();//вызывает интеррапт у потоков и гасит все сразу не дожидаясь выполнения у потоков

    }
}
