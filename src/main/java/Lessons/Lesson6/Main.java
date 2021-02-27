package Lessons.Lesson6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//что-бы добавить maven в обычный проект
//Нажать на папку с проектом правой кнопкой
//Выбрать "Добавить поддержку фреймворка" введите сюда описание изображения
//Выбрать из списка Maven

//Затем добавляем библиотеку(-и) в свой проект - File -- Project structure -- Project settings -- Libraries, нажимаем + и выбираем библиотеки из файловой системы.
//искал log4j

//В pom добаляю зависимость
//<dependencies>
//        <dependency>
//            <groupId>org.apache.logging.log4j</groupId>
//            <artifactId>log4j-api</artifactId>
//            <version>2.14.0</version>
//        </dependency>
//        <dependency>
//            <groupId>org.apache.logging.log4j</groupId>
//            <artifactId>log4j-core</artifactId>
//            <version>2.14.0</version>
//        </dependency>
//    </dependencies>

//настраиваем - log4j2.xml

public class Main {
  private static final Logger LOG = LogManager.getLogger(Main.class);
  public static void main(String[] args) {
  //LOG.trace("trace");//Тогда когда нужно выводить очень подробно информацию строчка за строчкой.
  //LOG.debug("debug");//Какая-то доп инф которая нам не всегда нужна.
  //LOG.info("info");//Просто информативные сообщения.
  //LOG.warn("warn");//Что-то происходит что мы не планировали но еще не фатальное.
  //LOG.error("error");//Тут и так понятно, ошибка , но программа еще может работать.
  //LOG.fatal("fatal");//Нам пиздешность, выполнение программы далее не имеет смысла.

    LOG.trace("Это trace сообщение.");

  }
}
