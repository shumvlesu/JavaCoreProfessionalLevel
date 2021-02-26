package Lessons.Lesson4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitExample {

    static class MessageDto{
        private String name;

        public MessageDto(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

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

        try {
            //метод submit возвращает нам какой то интерфейс что бы мы могли знать закончена задача или нет, прерывать ее и проч
            Future future = executorService.submit(runnable1);
            System.out.println("Задача поставлена");
            future.get();//в этот момент мы ожидаем остановки нашего потока и только потом продолжается выполнение программы

            //future.cancel(true);//отменяет выполнение потока.
            // true - сразу прекрать выполнение потока,
            // false - прекратить дождавшись выполнениея потока

            //в submit можно передать Callable
            //используя интерфейс Callable мы можем выполнять поток и возвращать результат
            Future<MessageDto> future2 = executorService.submit(new Callable() {
                public Object call() throws Exception {
                    System.out.println("Асинхронный вызов");
                    return new MessageDto("Результат из потока");
                }
            });
            System.out.println(future2.get().getName());


            System.out.println("Задача выполнена");
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
