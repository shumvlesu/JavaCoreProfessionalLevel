package Lessons.Lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main4 {
  public static void main(String[] args) {

    //ошибочный пример
    try (FileInputStream fileInputStream = new FileInputStream("src/Lessons/Lesson3/text2.txt")) {

      //при таком сравнении мы потеряем половину чтения
      while (fileInputStream.read()>-1){
        System.out.println(fileInputStream.read());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
