package Lessons.Lesson3;

import java.io.*;
import java.util.Arrays;

public class Main5 {
  public static void main(String[] args) throws IOException {
    byte[] array = new byte[10];
    Arrays.fill(array, (byte) 66);
    //второй параметр это размер буфера
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/Lessons/Lesson3/text2.txt",true),5);
    for (int i = 0; i < array.length; i++) {
      //когда буфер заполниться (у нас он размера 5), тогда в файл запишутся элементы массива
      //размер буфера(5) меньше размера массива (10), мы потеряли половину данных
      bufferedOutputStream.write(array[i]);
    }
    //flush() помогает протолкгуть остальные данные нашего массива,на которые у нас не хватило буфера, в FileOutputStream
    bufferedOutputStream.flush();
    //при flush надо закрывать поток
    bufferedOutputStream.close();

    //BufferedInputStream работает по аналогии только в обратную сторону
    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/Lessons/Lesson3/text2.txt"));
  }
}
