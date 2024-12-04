package basic.exam;

import java.util.Scanner;

public class 문제14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dice1 = sc.nextInt();
        int dice2 = sc.nextInt();
        int dice3 = sc.nextInt();
        int price = 0;
        int max = 0;

        if (dice1 == dice2 && dice2 == dice3) {
            price = 10000 + dice1 * 100;
        } else if (dice1 == dice2 || dice1 == dice3) {
            price = 1000 + dice1 * 100;
        } else if (dice2 == dice3) {
            price = 1000 + dice2 * 100;
        } else {
            max = Math.max(dice1, dice2);
            max = Math.max(max, dice3);
            price = max * 100;
        }
        System.out.println(price);

        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번째 주사위 값 : ");
        int dice_1 = sc.nextInt();
        System.out.println("두번째 주사위 값 : ");
        int dice_2 = sc.nextInt();
        System.out.println("세번째 주사위 값 : ");
        int dice_3 = sc.nextInt();

        if (dice_1 > max) max = dice_1;
        if (dice_2 > max) max = dice_2;
        if (dice_3 > max) max = dice_3;

        int same = 0;
        if (dice_1 == dice_2) same = same + 1;
        if (dice_2 == dice_3) same = same + 1;
        if (dice_3 == dice_3) same = same + 1;
        System.out.println("same = " + same);

    }
    }


