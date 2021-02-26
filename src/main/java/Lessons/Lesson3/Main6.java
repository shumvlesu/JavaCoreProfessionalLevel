package Lessons.Lesson3;

import java.io.*;

public class Main6 {
    public static void main(String[] args) throws IOException {
        //DataInputStream, DataOutputStream нужны для работы с пирмитивными типами данных
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/Lessons/Lesson3/text2.txt", true));
        dataOutputStream.writeUTF("Привет мир!");
        // Привет мир!

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/Lessons/Lesson3/text2.txt"));
        System.out.println(dataInputStream.readUTF());

    }
}
