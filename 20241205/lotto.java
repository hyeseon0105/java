package sort;

import java.util.Arrays;

public class lotto {
    public static void main(String[] args) {
        int[] lottoNumber = new int[6];
        int[] myNumber = new int[6];
        int num = 0;
        int count = 0;

        while (count < 6) {
            num= (int)(Math.random() * 45)+1;
//중복번호인지 확인
            boolean flag = false;
            for (int i = 0; i <= count; i++) {
                if (lottoNumber[i] == num) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                lottoNumber[count] = num;
                count++;
            }
        }
        System.out.println("로또당첨 번호 : " + Arrays.toString(lottoNumber));
    }
}
