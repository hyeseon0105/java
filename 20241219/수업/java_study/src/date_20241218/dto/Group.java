package date_20241218.dto;

public class Group {
    private String name = "나는 너의 부모다";

    public void greeting() {
        System.out.println("안녕하세요");


    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
