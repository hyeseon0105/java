package basic.exam;

import java.util.Scanner;

public class 문제9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 라인수를 입력 : ");
        int line = scanner.nextInt();
        String star = "";
        for (int i = line; i > 0; i--) {
            for (int j = 1; j <= i; j++) {

                star = star + "*";
            }
            System.out.println(star);
            star = "";

        }
        }
    }

