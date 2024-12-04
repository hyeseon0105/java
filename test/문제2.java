package basic.exam;

public class 문제2 {
    public static void main(String[] args) {
        for (int i = 10; i >= 1; i--) {
            if (i == 3) continue;
            System.out.println(i);
        }
        int j = 11;
        do {
            j--;
            if (j == 3) {
                continue;
            } else {
                System.out.println(j);

            }
        } while (j > 0) ;

    }
}
