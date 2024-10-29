package javacax;
import java.util.*; // подсос всего из java util

public class Human implements Comparable<Human> {
    private String name;
    private String surname;
    private int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getmame() {
        return name;
    }

    public String getsurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        return this.surname.compareTo(other.surname);
    }

    @Override
    public String toString() {
        return "Human{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + '}';
    }
}