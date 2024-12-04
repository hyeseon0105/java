package basic.myPagage;

import java.util.Arrays;

public class 문제4 {
    public static void main(String[] args) {
        int[] a = {9, 8, 2, 4, 3};
        int tempValue;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    tempValue = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tempValue;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
