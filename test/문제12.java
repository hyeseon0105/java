package basic.exam;

import java.util.Scanner;

public class 문제12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시간입력: ");
        int hh = scanner.nextInt();
        System.out.println("분 입력: ");
        int mm = scanner.nextInt();
        if (mm >= 45) {
            mm = mm - 45;

        } else if (hh == 0 && mm < 45) {
            hh = 23;
            mm = mm + 15;
        } else {
            hh = hh - 1;
            mm = mm + 15;

        }
        System.out.println(hh + " " +mm);
    }
}
