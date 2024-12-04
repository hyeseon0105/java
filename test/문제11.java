package basic.exam;

import java.util.Scanner;

public class 문제11 {
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            int score = 100;
            if (score >= 90) {
                System.out.println("A");
            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            } else if (score >= 60) {
                System.out.println("D");
            } else if (score >= 50) {
                System.out.println("E");
            } else if (score >= 40)
                System.out.println("F");
        }





    Scanner scanner = new Scanner(System.in);
    System.out.println("점수를 입력하세요");
    int score = scanner.nextInt();
        if (score >= 90) {
            System.out.println("당신의 결과는 : A");
        } else if (score >= 80) {
            System.out.println("당신의 결과는 : B");
        } else if (score >= 70) {
            System.out.println("당신의 결과는 : C");
        } else if(score >=60) {
            System.out.println("당신의 결과는 : D");
        } else {
            System.out.println("당신의 결과는 : F");
    }
}
}



