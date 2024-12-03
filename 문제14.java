package basic.exam;

import java.util.Scanner;

public class 문제14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dice1 = s.nextInt();
        int dice2 = s.nextInt();
        int dice3 = s.nextInt();
        int price = 0;
        int max = 0;

        if (dice1 == dice2 && dice2 == dice3) {
            price = 10000 + dice1 * 100;
        } else if (dice1 == dice2 || dice1 == dice3) {
            price = 1000 + dice1 * 100;
        } else if (dice2 == dice3) {
            price = 1000 + dice2 * 100;
        }else {
            max = Math. max(dice1, dice2);
            max = Math.max(max, dice3);
            price = max * 100;
        }
        System.out.println(price);
    }
}
