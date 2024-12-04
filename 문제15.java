package basic.exam;

import java.util.Scanner;

public class 문제15 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = 0;
        String userid = "";
        String pessword = "";
        //로그인확인 용도의 변수
        boolean longln = false;


        while (true) {
            if (longln == false) {
                while (true) {
                    System.out.println("아이디 : ");
                    userid = scanner.next();
                    System.out.println("비밀번호 : ");
                    pessword = scanner.next();
                    if (! userid.equals("admin") && ! pessword.equals("1111")) {
                        System.out.println("아이디 또는 비밀번호를 확인하세요.");
                        continue;
                    } else if (userid.equals("admin") && ! pessword.equals("1111")) {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        continue;
                    } else {
                        System.out.println("로그인이 되었습니다.");
                        longln = true;
                        break;
                    }

                }
                System.out.println("======================");
            }
            System.out.println("메뉴를 선택하세요");
            System.out.println("======================");
            System.out.println("1. 인사하기 2. 춤추기 3. 밥먹기 4. 로그아웃 5. 종료하기");
            System.out.println("원하는 번호를 입력하세요");
            input = scanner.nextInt();
            switch (input) {
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
                    System.out.println("로그아웃 되었습니다.");
                    longln = false;
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘 못 입력했습니다.");
            }
        }
    }

    }

