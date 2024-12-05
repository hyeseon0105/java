package sort;

public class 문제2 {
    public static void main(String[] args) {
        final int TIMES = 70000;
        int[] dice = new int[11];
            int dice_1 = 0;
            int dice_2 = 0;
            int diceSUM = 0;
        for (int i = 0; i <= TIMES; i++) {
            dice_1 =((int)(Math.random()*6))+1;
            dice_2 =((int)(Math.random()*6))+1;
            diceSUM = dice_1 + dice_2;
            dice[diceSUM - 2]=dice[diceSUM - 2]+1;
        }
        System.out.println("output : ");
        double rate = 0.0;
        String strRate = "";
        for (int i = 0; i < dice.length; i++) {
            rate =(double) dice[1] / TIMES;
            strRate = String.format("%.6f", rate);

            System.out.println((i + 2) + " : "+ dice[i] + "(" + strRate + ")");
        }

        }
    }


