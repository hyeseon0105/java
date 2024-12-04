package basic.condition;

public class BreakCondition {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
            if (i == 5) {
                continue;

            }

        }
        System.out.println(" sum = " + sum);
    }
}
