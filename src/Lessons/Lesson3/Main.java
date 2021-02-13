package Lessons.Lesson3;

import java.io.File;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {


    File file = new File("test.txt");//файл еще не существует на жд
    File file2 = new File("src/Lessons/Lesson3/text2.txt"); //а этот я создал руками, с абсолютным путем
    File file3 = new File("src/Lessons/Lesson3/");//просто каталог присваиваю
    File file4 = new File("src/Lessons/Lesson3/test/test_directory");//просто каталог присваиваю

    System.out.println(file.exists()); //показывает существует файл или нет
    System.out.println(file2.exists()); //показывает существует файл или нет

    System.out.println(file.getName());//возвращает имя файла
    System.out.println(file.getParent());//возвращает родительский каталог файла, у меня null т к я не использую абсолютный путь.
    System.out.println(file2.getParent());//а тут вернет - src\Lessons\Lesson3
    System.out.println(file2.length());//Длинна файла в байтах, каждый символ 2 байта - привет! == 13 байт

    System.out.println(file2.isFile());//за экземпляром file2 класса File скрывается файл?
    System.out.println(file2.isDirectory());//за экземпляром file2 класса File скрывается папка?

    System.out.println(Arrays.toString(file3.listFiles()));//вернет массив экземпляров класса File
    System.out.println(Arrays.toString(file3.list()));//вернет название всех файлов что в данной директории



    System.out.println(file4.mkdir());//создает последнюю папку в пути (test_directory, ее до этой строки не существует еще)
    //однако test_directory указана в еще тоже не существующей папке test. Так что метод сейчас не отработает
    // а вот mkdirs создаст и test и test_directory в этом их и отличие.
    System.out.println(file4.mkdirs());


  }
}
