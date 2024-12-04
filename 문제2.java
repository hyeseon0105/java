package basic.myPagage;

public class 문제2 {
    public static void main(String[] args) {
        int[] dice = new int[11];
        for (int i = 0; i < dice.length; i++) {
            int dice_1 = 0;
            int dice_2 = 0;
            dice[dice_1 + dice_2]++;

            dice_1= (int) Math.random() * 6 + 1;
            dice_2 = (int) Math.random() * 6 + 1;
        }

                 
    }
}
