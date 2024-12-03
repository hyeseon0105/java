package basic.exam;

import java.util.Scanner;

public class 문제6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        System.out.println("첫번째 수를 입력하세요 : ");
        int fistNumber = scanner.nextInt();
        System.out.println("두번째 수를 입력하세요 : ");
        int secondNumber = scanner.nextInt();
        if (fistNumber > secondNumber) {
            int temp = fistNumber;
            fistNumber = secondNumber;
            secondNumber = temp;
        }
        int sum = 0;

        for (int j = fistNumber; j <= secondNumber; j++) {


        }
    }
}
