package basic.exam;

public class 문제1 {
    public static void main(String[] args) {
        //1부터 10까지의 수를 출력하세요
        for (int i = 1; i <= 10; i++) {
            if (i == 6) continue;
            System.out.println(i);
        }
        int j = 0;
        while (j < 10) {
            j++;
            if (j == 6) continue;
            System.out.println(j);


        }

        }
    }

