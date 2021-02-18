package Lessons.Lesson4;

public class Main {
  public static void main(String[] args) {

    //1) Первый способ создания потока через класс Thread и обязательное переопределение метода run()
    Thread thread1 = new Thread() {
      @Override
      public void run() {

        for (int i = 0; i < 3 && !isInterrupted(); i++) {
          System.out.println("Привет!");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            //e.printStackTrace();
            //в момент когда вызвали interrupt(), поток мог находиться в режиме сна
            //и в таком случае сработает исключение InterruptedException
            //поэтому поставим return(), ведь мы знаем что такая ситуация может произойти.
            return;
          }

        }

      }
    };


    //2) С помощью интерфейса Runnable и также перопределения run()
    Thread thread2 = new Thread(new Runnable(){
      @Override
      public void run() {
        for (int i = 0; i < 3 && !Thread.currentThread().isInterrupted(); i++) {
          System.out.println("Пока!");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            //e.printStackTrace();
            return;
          }

        }
      }
    });

    thread1.start();//вызваю поток
    thread2.start();
    //thread2.interrupt();//для остановки потока. метод stop - деприкейтед.
    //Для метода interrupt(), в потоке, что бы он правильно его завершил, надо определить место где поток может прекратить работу,
    //надо постаить isInterrupted()
    //А вот у потока который имплементирует интерфейс Runnable метод isInterrupted() использовать нельзя
    //нужно будет у калсса Thread вызвать метод currentThread() и у него уже вызвать метод isInterrupted() - Thread.currentThread().isInterrupted()


  }
}
