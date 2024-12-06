package Study;

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = 0;
        System.out.println("나이를 입력하세요.");
        age = scanner.nextInt();
        System.out.println(age);
        if (age >= 20) {
            System.out.println("투표 가능합니다.");
        }else
            System.out.println("투표 불가능합니다.");
    }
}
