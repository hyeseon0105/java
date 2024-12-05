package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[]data = {9,8,2,4,3};
        System.out.println("초기데이터 : " + Arrays.toString(data));
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1 ]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                } else {
                    break;

                }
            }
            System.out.println(i+ "단계: " + Arrays.toString(data));
        }

}
    }