package Lessons.Lesson3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Main2 {
  public static void main(String[] args) {
    //потоки ввода/вывода
    //1) потоки байтовые , работают с любым типом данных
    //все байтовые потоки имеют суфиксы InputStream OutputStream, это абстрактные классы
    //у InputStream есть  метод read, это дорогая операция так как читает он по байтово
    //у OutputStream есть write
    //и read и write прегруженные методы, где можно в том числе и использовать запись/чтение массива где в параметрах
    //можно указать начальный и конечный индекс массива куда писать байты

    //2) потоки символьные, лучше работать с текстовыми типами данных
    //все символьные потоки имеют суфиксы Reader Writer

    byte[] array = new byte[100];
    array[0] = 45;

    //2 конструктора байтового массива
    //читаем array
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
    System.out.println(byteArrayInputStream.read());
    System.out.println(byteArrayInputStream.read());
    System.out.println(byteArrayInputStream.read());

    //пишем в byteArrayOutputStream какието данные
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byteArrayOutputStream.write(66);
    byteArrayOutputStream.write(67);
    byteArrayOutputStream.write(68);
    //а теперь byteArrayOutputStream переносим в array
    array = byteArrayOutputStream.toByteArray();
    System.out.println(Arrays.toString(array));


  }
}
