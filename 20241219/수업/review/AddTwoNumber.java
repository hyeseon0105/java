package review;

import java.util.Scanner;

public class AddTwoNumber {
    public static void main(String[] args) {
        //두 수를 입력 받아서 합계를 구하는 프로그램
        //1.두 수를 스캐너를 통해 입력 받는다.
        //문제점: 앞 수가 더 큰 경우는 두 수를 바꿔줘야함.
        //2. 두 수 사의의 값들을 합한다.

        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번째 수를 입력하시오. ");
        int oneNumber = scanner.nextInt();
        //두번재 수를 입력 받는다.
        System.out.println("두번째 수를 입력하시오. ");
        int twoNumber = scanner.nextInt();
//두수를 비교해서 첫번째값이 크면 두수를 바꾼다.
        if (oneNumber > twoNumber) {
            int temp = oneNumber;
            oneNumber = twoNumber;
            twoNumber = temp;
        }
        //2.두 수 사이의 값들을 합한다.
       for (int i = oneNumber; i <= twoNumber; i = i + 1) {
           sum = sum + i;
      }

//        while (oneNumber <= twoNumber) {
//            sum = sum + oneNumber;
//            oneNumber++;
//       }
        System.out.println("값 :" + sum);

    }
}
