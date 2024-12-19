package date_20241218.dto;

public class GirlGroup extends Group{
    private String name;

    public void dance() {
        System.out.println("걸그룹이 안무를 합니다.");
    }

    @Override
    public void greeting() {
        System.out.println(name+"에요~~~~~~");
    }

    @Override
    public String toString() {
        return "GirlGroup{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
