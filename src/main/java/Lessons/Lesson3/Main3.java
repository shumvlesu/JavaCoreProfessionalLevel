package Lessons.Lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main3 {
  public static void main(String[] args) {

    //потоки ввода/вывода для которых источником является файл
    //эти конструкторы пергруженны и могут иметь флаг записи в конец фала или с начала файла
    try (FileInputStream fileInputStream = new FileInputStream("src/Lessons/Lesson3/text2.txt")) {
      int x;
      while ((x=fileInputStream.read())>-1){
        System.out.println(x);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    byte[] array = new byte[1000000];
    Arrays.fill(array, (byte) 66);
    //пример записи в файл
    try (FileOutputStream fileOutputStream = new FileOutputStream("src/Lessons/Lesson3/text2.txt", true)){//флаг записи в конец файла

      long start =  System.currentTimeMillis();
      for (byte b : array) {
        fileOutputStream.write(b);
      }
      long finish =  System.currentTimeMillis();
      System.out.printf("Поэлементная запись в файл:%s\n", TimeUnit.MILLISECONDS.toSeconds(finish-start));


      start =  System.currentTimeMillis();
      fileOutputStream.write(array);
      finish =  System.currentTimeMillis();
      System.out.printf("Запись всего массива сразу в файл:%s\n", TimeUnit.MILLISECONDS.toSeconds(finish-start));

//      for (int i = 0; i < 5; i++) {
//        fileOutputStream.write(i+60);
//      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
