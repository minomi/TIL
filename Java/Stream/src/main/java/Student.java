/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */

public class Student implements Comparable<Student> {
    public enum Sex {MALE, FEMALE}
    public enum City {SEOUL, PUSAN}

    private String name;
    private int score;
    private Sex sex;
    private City city;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, Sex sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    public Student(String name, int score, Sex sex, City city) {
        this.name = name;
        this.score = score;
        this.sex = sex;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isMail() {
        return sex == Sex.MALE;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score ,o.score);
    }
}
