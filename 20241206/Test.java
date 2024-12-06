package Study;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        System.out.println("점수를입력하세요");
        score = scanner.nextInt();
        if (score >= 90) {
            System.out.println("A");
        } else if (score>=80 ) {
            System.out.println("B");
        } else if (score>=70 ) {
            System.out.println("C");
        } else if (score>=60) {
            System.out.println("D");
        } else
            System.out.println("F");
    }
}
