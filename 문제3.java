package basic.myPagage;

import java.util.Arrays;

public class 문제3 {
    public static void main(String[] args) {
        int[] a = {4, 1, 2, 5, 3};
        int tempvalue, tempj = 0;
        for (int i = 0; i < a.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    tempj = j;
                }
            }
            tempvalue = a[i];
            a[i] = a[tempj];
            a[tempj] = tempvalue;

        }
        System.out.println(Arrays.toString(a));

    }
}
