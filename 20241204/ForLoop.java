package basic.condition;

public class ForLoop {
    public static void main(String[] args) {
        // 1부터 5까지 더하고 싶어요
        //1+2+3+4+5
        int value = 0;
        int sumValue = 0;
        value = value + 1;
        sumValue = sumValue + value;
        value = value + 1;
        sumValue = sumValue + value;
        value = value + 1;
        sumValue = sumValue + value;
        value = value + 1;
        sumValue = sumValue + value;
        value = value + 1;
        sumValue = sumValue + value;
        System.out.println(sumValue);

        sumValue = 0;
        for (int i = 0; i <= 5 ; i ++) {
            sumValue = sumValue + i;
        }
        System.out.println("===" + sumValue);


        for (int i = 5; i > 0; i --) {
            System.out.println("김형민");
        }

        // 이중 For 구문
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
            for (int j = 1; j <= 5; j++) {
                System.out.println("j = " + j);
            }
        }
    }
}
