package Study;

import java.util.Scanner;

public class Hyeseon {
    public static void main(String[] args) {
        String[] product = new String[5];
        product[0] = "콜라";
        product[1] = "사이다";
        product[2] = "커피";
        int[] price = new int[5];
        price[0] = 500;
        price[1] = 700;
        price[2] = 1500;
        int[] stock = new int[5];
        stock[0] = 3;
        stock[1] = 3;
        stock[2] = 3;

        while (true) {
            System.out.println("=========================================================");
            System.out.println("자판기입니다.(번호: 상품 (가격) - 재고");
            System.out.println(" 1.콜라(500w) - 3개 2.사이다(700w) - 3개 3.커피(1500w) - 3개");
            System.out.println("=========================================================");
            Scanner scanner = new Scanner(System.in);

            System.out.println("돈을 넣어주세요.");
            int angle = scanner.nextInt();

            if (angle == 1004) {
                System.out.println("관리자 페이지 입니다.");
                System.out.println("1.메뉴변경 "+ "2.가격변경 "+ "3.메뉴추가 "+ "4.메뉴추가"+ "수익확인 (종료는 -1)");
                System.out.println("번호를 입력하세요. ");
            int money = scanner.nextInt();
            System.out.println(money+"원");
            System.out.println("메뉴입력 : ");
            int num = scanner.nextInt();
            if (money < price[num]) {

                System.out.println("잔액이 부족합니다.");
            } else {
                System.out.println(product[num]+" 이 (가) 나왔다!");
            }
            System.out.println("잔액 : "+ (money+ - price[num])+"원");
            System.out.println("1.계속 구매하기 "+ "2.금액 추가하기 "+ "3.잔돈 반환하기 ");
            System.out.println("번호를 입력하세요.");
            int numm = scanner.nextInt();
            if (numm== 3) {
                System.out.println("거스름돈 : " +(money+ - price[num])+"원이 반환됩니다." );
                System.out.println("감사합니다 다음에 또 이용해주세요!!!");
            }

            }
        }
    }
}
