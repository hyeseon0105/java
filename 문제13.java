package basic.exam;

import java.util.Scanner;

public class 문제13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int sum = b + c;
        int hour = sum / 60;
        if (a + hour > 23) {
            System.out.println((a = (hour) - 24) + "" + (sum - (hour * 60)));

        } else {
            System.out.println(a + (hour + "" + (sum - (hour * 60))));
        }


    }
}
