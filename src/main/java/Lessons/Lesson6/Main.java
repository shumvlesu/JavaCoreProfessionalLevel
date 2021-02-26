package Lessons.Lesson6;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//что-бы добавить maven в обычный проект
//Нажать на папку с проектом правой кнопкой
//Выбрать "Добавить поддержку фреймворка" введите сюда описание изображения
//Выбрать из списка Maven

//Затем добавляем библиотеку(-и) в свой проект - File -- Project structure -- Project settings -- Libraries, нажимаем + и выбираем библиотеки из файловой системы.
//искал log4j

public class Main {
  private static final Logger LOG = LogManager.getLogger(Main.class);

  public static void main(String[] args) {
    LOG.trace("trace");
    LOG.debug("debug");
    LOG.info("info");//
    LOG.warn("warn"); //что-то происходит что мы не планировали но еще не фатальное
    LOG.error("error");//тут и так понятно, ошибка , но программа еще может работать
    LOG.fatal("fatal");//нам пиздешность, выполнение программы далее не имеет смысла
  }
}
