package Lessons.Lesson3;

import java.io.*;

public class Main8 {
    public static void main(String[] args) throws IOException {
        //символьные потоки
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Lessons/Lesson3/text2.txt", true));
        writer.write("llllll");
        writer.flush();//это буферизированный метод, надо сделать flush()
        BufferedReader reader = new BufferedReader(new FileReader("src/Lessons/Lesson3/text2.txt"));

        while (reader.ready()){//можем ли еще что то считать
            System.out.println(reader.readLine());
        }

    }
}
