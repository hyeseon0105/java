package sort;

import java.util.Arrays;

public class lottod {
    public static void main(String[] args) {
        int[] lottoNumber = new int[6];
        int[] myNumber = new int[6];
        //기계에서 추첨
        creatLottoNumber(lottoNumber);
        System.out.println("로또당첨 번호 : " + Arrays.toString(lottoNumber));
//나의 로또번호구매
        creatLottoNumber(myNumber);
        System.out.println("내가 산 로또당첨 번호 : " + Arrays.toString(myNumber));
        lottoCheak(lottoNumber,myNumber);
    }

    private static void lottoCheak(int[] lottoNumber, int[] myNumber) {
        //몇개 당첨됐는지 확인하는 변수
        int count = 0;
        //밖의 for는 내 번호를 하나씩 읽어서 비교하는 용도
        for (int i = 0; i < lottoNumber.length; i++) {

            //당청번호를 무조건 다 읽어서 맞는지 확인
            for (int j = 0; j < lottoNumber.length; j++) {
                if (myNumber[i] == lottoNumber[j]) {
                    System.out.println("당첨번호 : "+ myNumber[i]);
                    count++;
                }
            }
        }
        System.out.println("맞은갯수 : " + count);
    }

    private static void creatLottoNumber(int[] lotto) {
        int num = 0;
        int count = 0;

        while (count < 6) {
            num= (int)(Math.random() * 45)+1;
//중복번호인지 확인
            boolean flag = false;
            for (int i = 0; i <= count; i++) {
                if (lotto[i] == num) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                lotto[count] = num;
                count++;
            }
        }
    }
}


