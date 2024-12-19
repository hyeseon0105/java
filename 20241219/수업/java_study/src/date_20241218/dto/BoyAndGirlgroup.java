package date_20241218.dto;

public class BoyAndGirlgroup implements GroupInterface{
    @Override
    public void greeting() {
        System.out.println("인사");
    }

    @Override
    public String getName() {
        return "나는 보이걸그룹";
    }

    @Override
    public void setName(String name) {

    }
}
