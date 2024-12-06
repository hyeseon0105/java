package Study;

import java.util.Scanner;

public class Num {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        System.out.println("나이를 입력하세요.");
        num = scanner.nextInt();
        System.out.println(num);
        if (num % 2 == 1) {
            System.out.println("홀수입니다.");
        }else
            System.out.println("짝수입니다.");

    }
}
