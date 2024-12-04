package basic.condition;

public class DoLoopTest {
    public static void main(String[] args) {
        // while --- 하는동안
        //Do (실행문) ~ while(조건) (--하는동안)
        // while 구문
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            sum = sum + 1;
            i = i + 1;
            System.out.println(i);
            }

        i = 1;
        sum = 0;

        do {
            sum = sum + i;
            i = i + 1;
        } while (i <= 10 );
        System.out.println(sum);
        }
    }
