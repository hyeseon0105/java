package basic.myPagage;

import java.util.Arrays;

public class 문제5 {
    public static void main(String[] args) {
        int[] a = {9, 8, 2, 4, 3};
        int tempValue, tatget;
        for (int i = 0; i < a.length; i++) {
            tempValue = a[i];
            tatget = i - 1;
            while (tatget >= 0 && a[tatget] > tempValue) {
                a[tatget + 1] = a[tatget];
                tatget--;

            }
            a[tatget + 1] = tempValue;
        }
        System.out.println(Arrays.toString(a));

    }
}
