package basic.exam;

import java.util.Scanner;

public class 문제4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("값을 입력하세요 : ");
        int inputValue = scanner.nextInt();
        int sumValue = 0;
        for (int i = 1; i <= inputValue; i++) {
            for (int j = 1; j <= i; j++) {
                sumValue = sumValue + j;
            }

        }
        System.out.println("결과 :" +sumValue);


        }

    }

