package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] data = {4, 2, 3, 1, 5};
        //비꿀 대상의 인덱스
        int index = 0;
        //바뀔 위치를 치청하는 기능
        int min = 9999999;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    index = j;


                }
            }
            if (index == i) {
                break;
            } else {
                //가장 작은 값은 인덱스를 찾으면 두개를 교환
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
                //인쇄
                System.out.println((i + 1) + "단계 : " + Arrays.toString(data));
                min = 9999999;

            }
        }
    }
}
