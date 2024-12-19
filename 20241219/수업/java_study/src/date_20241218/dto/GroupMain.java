package date_20241218.dto;

import java.util.ArrayList;
import java.util.List;

public class GroupMain {
    public static void main(String[] args) {
        List<Group> groups = new ArrayList<>();

        Group boyGroup = new BoyGroup();
        boyGroup.setName("세븐틴");
        System.out.println(boyGroup.getName());
        boyGroup.greeting();

        GirlGroup girlGroup = new GirlGroup();
        girlGroup.setName("뉴진스");
        System.out.println(girlGroup.getName());
        girlGroup.greeting();

        System.out.println(girlGroup.toString());
        groups.add(boyGroup);
        groups.add(girlGroup);
        groups.get(0).greeting();
        ((GirlGroup)groups.get(1)).dance();

        GroupInterface boyAndGirl = new BoyAndGirlgroup();

    }
}
