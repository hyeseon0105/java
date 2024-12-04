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

        Scanner sc = new Scanner(System.in);
        System.out.println("현재시간 : ");
        int hh = sc.nextInt();
        System.out.println("현재 분 : ");
        int mm = sc.nextInt();
        System.out.println("요리시간 : ");
        int time = sc.nextInt();
        int totalTime = (hh * 60) + mm + time;

        hh = (totalTime / 60)%24;
        mm = totalTime % 60;
        System.out.println(hh+" "+mm);
    }
}
