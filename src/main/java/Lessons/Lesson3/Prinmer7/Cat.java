package Lessons.Lesson3.Prinmer7;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private int age;
    private transient String breed;//transient говорит что этополе сериализовывться не будет
    //Если есть поля и они объектного типа. Классы этих объектов тоже должны быть сериализуемыми
    //Иначе будет исключение

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "имя: "+this.name+", возраст: "+this.age;
    }
}
