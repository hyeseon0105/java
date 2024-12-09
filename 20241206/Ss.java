import java.util.Scanner;

public class Ss {
    static int[] price = new int[5];
    static String[] product = new String[5];
    static int[] stock = new int[5];
    static int showtotle = 0;
    static boolean first=true;
    static int money=0 ;
    public static void main(String[] args) {

        product[0] = "콜라";
        product[1] = "사이다";
        product[2] = "커피";
        price[0] = 500;
        price[1] = 700;
        price[2] = 1500;
        stock[0] = 3;
        stock[1] = 3;
        stock[2] = 3;


        while (true) {

            System.out.println("=======================================================");
            System.out.println("자판기 입니다. (번호 : 상품 (가격) - 재고)");
            String menu = "";
            for (int i = 0; i < product.length; i++) {
                if (product[i] != null) {
                    menu = menu + (i+1) + ":" + product[i] + "(" + price[i]+"W)" + stock[i]+"-개";
                }
            }
            System.out.println(menu);
            System.out.println("=======================================================");
            Scanner scanner = new Scanner(System.in);

            if (money <= 0) {
                System.out.println("돈을 넣어주세요.");
                money = scanner.nextInt();//돈
                first = false;
            }

            if (money == 1004) {
                admin();
            } else {
                System.out.println("잔액" +money + "원");
                System.out.println("메뉴 입력 :");
                int num = scanner.nextInt();
                if (money < price[num - 1]) {
                    System.out.println("잔액이 부족합니다!");
                } else {
                    System.out.println(product[num - 1] + "이(가) 나왔다!");
                    stock[num - 1]--;
                    money -= price[num - 1];
                    showtotle += price[num - 1];
                    System.out.println("잔액 : " + money + "원");

                }
            }



                System.out.println("1  : 계속 구매하기 2: 금액 추가하기 3 : 잔돈 반환하기");
                System.out.println("번호를 입력하세요.");
                int numm = scanner.nextInt();//거스름돈
                if (numm == 2) {
                    System.out.println("추가할 금액을 입력하세요");
                    int adddmoney = scanner.nextInt();
                     money += adddmoney;
                    System.out.println("현재 잔액: " + money + "원");

                } else if (numm == 3) {
                    System.out.println("거스름돈" +  money + "반환 됩니다.");
                    money = 0;
                    System.out.println("감사합니다! 다음에 또 이용해주세요!!!");

                } else if (numm == 1) {
                    continue;

                } else {
                    System.out.println("입력오류");
                }
        }

    }

    private static void admin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=======================================================");
            System.out.println("관리자 페이지입니다.");
            System.out.println("1 : 메뉴변경 2 : 가격변경 3 : 재고추가 4 :메뉴추가 5 : 수익확인 (종료는 - 1)");
            System.out.println("번호를 입력하세요.");
            System.out.println("=======================================================");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("변경하실 메뉴의 번호를 입력하세요. ( 1 - 3 ) ");
                int change = scanner.nextInt() ;
                System.out.println(product[change-1]+"을 (를) 무엇으로 바꾸겠습니까?");
                String tochange = scanner.next();
                product[change-1] = tochange;
                System.out.println(product[change-1] +"의 가격은 얼마입니까?");
                int toPrice = scanner.nextInt();
                price[change-1] = toPrice;
                System.out.println(product[change-1]+"의 재고를 몇개 등록하시겠습니까?");
                int tostock = scanner.nextInt();
                stock[change-1] = tostock;
                System.out.println("메뉴 변경이 완료되었습니다!");
                System.out.println("=======================================================");
                continue;

            } else if (choice==2) {
                System.out.println("=======================================================");
                System.out.println("가격을 변경하실 메뉴의 번호를 입력하세요. (1 - 3)");
                int chprice = scanner.nextInt();
                System.out.println(product[chprice-1] +"의 가격을 얼마로 바꾸시겠습니까?");
                int chhprice = scanner.nextInt();
                price[chprice-1] = chhprice;
                System.out.println("가격 변경이 완료되었습니다.");
                continue;

            } else if (choice == 3) {
                System.out.println("재고를 추가하실 메뉴의 번호를 입력하세요 (1 - 3) ");
                int chproduct = scanner.nextInt();
                System.out.println();
                System.out.println(product[chproduct-1] + "을(를) 몇개 추가 하시겠습니까?");
                int chstock = scanner.nextInt();
                System.out.println("재고 추가가 완료되었습니다.");


                continue;


            }else if (choice == 4) {
                boolean flag = false;
                for (int i = 0; i < product.length; i++) {
                    if (product[i] == null) {
                        flag = true;
                        // 추가 작업 진행
                        System.out.println("추가하실 메뉴의 이름을 입력하세요 : ");
                        product[i] = scanner.next();
                        System.out.println("추가하실 메뉴의 가격을 입력하세요 : ");
                        price[i] = scanner.nextInt();
                        System.out.println(product[i] + "재고는 몇 개 입니까");
                        stock[i] = scanner.nextInt();
                        System.out.println("메뉴 추가가 완료 되었습니다.");
                        flag = true;
                        break;
                    }
                }
                if (!flag ) {
                    System.out.println("더 이상 메뉴가 들어갈 자리가 없습니다.");
                }
                continue;


            } else if (choice == 5) {
                System.out.println("=======================================================");
                System.out.println("현재까지 수익은 ? "+showtotle+"원");
                continue;

            } else if (choice == -1) {
                System.out.println("관리자 페이지 종료입니다.");
                System.exit(0);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        }
        }


