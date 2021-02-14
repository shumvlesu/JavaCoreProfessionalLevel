package Lessons.Lesson3.Prinmer7;
import java.io.*;
import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) throws IOException {
        //сериализация и десериализация это запись наших объектов в виде массива байтов
        Cat cat = new Cat("Барсик", 6);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        //можно и в файл выгрузить сериализированый объект.
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/Lessons/Lesson3/text2.txt"));
        //только если сам класс изменится, пока мы храним объект в файле, то мы получим исключение ClassNotFoundException

        objectOutputStream.writeObject(cat);
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));


        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        try {
          Cat cat2 = (Cat) objectInputStream.readObject();
          System.out.println(cat2.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
