package sort;

public class 문제7 {
    public static void main(String[] args) {
        int[] Lotto = new int[6];
        System.out.println("Lotto 선택 숫자는 ");
        for (int i = 0; i < Lotto.length; i++) {
            Lotto[i] = (int) (Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
                if (Lotto[i] == Lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < Lotto.length; i++) {
            System.out.println(Lotto[i]+"");
            System.out.println("입니다. ");
        }
    }
}