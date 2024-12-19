package date_20241218.dto;

public class Idol {
    private String namne;
    private int age;

    //기본 생성자
    public Idol() {}

    public Idol(String namne, int age) {
        this.namne = namne;
        this.age = age;

    }

    public String getNamne() {
        return namne;
    }

    public void setNamne(String namne) {
        this.namne = namne;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void action() {
        System.out.println();
    }
}
