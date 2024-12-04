package basic.myPagage;

import java.util.Arrays;
import java.util.Scanner;

public class JuminCheak {
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("주민등록번호를 13자리를 연속해서 입력하세요.(-제외)");
        String[] strJumin = scanner.next().split( "" );
        System.out.println(Arrays.toString(strJumin));

        int[] jumin = new int[strJumin.length];
        for (int i = 0; i < strJumin.length; i++) {
            jumin[i] = Integer.parseInt(strJumin[i]);
        }
        System.out.println(jumin);
        for (int i = 0; i < jumin.length-1; i++) {
            if (i < 8) {
                result = result + (jumin[i] * (i + 2));
            } else {
                result = result + (jumin[i] * (i - 6));
            }
        }
        //결과 = 11로 나눈 나머지
        result = result % 11;
        //결과 = 11 - 결과
        result = 11 - result;
        //결과 = 결과를 10으로 나눈 나머지
        result = result % 10;

        //맞는지 틀렸는지:결과 == jumin[12]
        if (result == jumin[12]) {
            System.out.println("올바른 주민번호 입니다.");
        } else {
            System.out.println("잘못된 주민번호 입니다.");
        }
    }
}
