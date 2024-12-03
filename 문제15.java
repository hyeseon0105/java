package basic.exam;

import java.util.Scanner;

public class 문제15 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        do {

            System.out.println("======================\n" +
                    "메뉴를 선택하세요\n" +
                    "======================");
            System.out.println("1. 인사하기 2. 춤추기 3. 밥먹기  4. 종료하기");
            System.out.println("원하는 번호를 입력하세요");
            n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("안녕하세요.");
                    break;
                case 2:
                    System.out.println("삐끼삐끼 춤입니다.");
                    break;
                case 3:
                    System.out.println("맛나게 먹었습니다.");
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        } while (n >= 1 && n <= 4);
        }
    }

