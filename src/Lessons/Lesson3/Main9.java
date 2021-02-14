package Lessons.Lesson3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Main9 {
    public static void main(String[] args) throws IOException {
        //случайное чтение из файла
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/Lessons/Lesson3/text2.txt", "rw"); //ключ - r (чтение), rw (чтение и запись)
        //в файле - 123456789
        randomAccessFile.seek(2);//читаем со 2го байта в нашем файле
        System.out.println(randomAccessFile.readLine());
        //выведет - 3456789

        byte[] array = new byte[2000];
        randomAccessFile.seek(3);//читаем со 2го байта в нашем файле
        randomAccessFile.read(array);
        System.out.println(new String(array, StandardCharsets.UTF_8));
        //выведет - 456789
    }
}
