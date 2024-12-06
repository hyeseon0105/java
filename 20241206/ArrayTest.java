package Study;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(num));
        String[] 과일 = new String[5];
        과일[0] = "사과";
       // 과일[1] = "귤";
        과일[2] = "포도";
        과일[3] = "키위";
        int[]price = new int[5];
        price[0] = 1000;
       // price[1] = 2000;
        price[2] = 3000;
        price[3] = 4000;
        for (int i = 0; i < 과일.length; i++) {
            if (과일[i] != null) {

                System.out.println(과일[i] + "(" + price[i] + "원)");
            }

        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("몇번쨰 과일바구니를 수정하겠습니까 ?");
            int a=scanner.nextInt();
            System.out.println(과일[a] + "선택하였습니다.");
            System.out.println("무엇으로 바꿀까요 ? ");
            String 과일이름 = scanner.next();
            과일[a] = 과일이름;
            System.out.println(Arrays.toString(과일));
            System.out.println("종료할까요? (Y/N)");
            String 답 = scanner.next();
            if (답.equals("Y")) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}
