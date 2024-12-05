package sort;

public class MaxAndMinNumber {
    public static void main(String[] args) {
        int[] num = {3, 29, 38, 12, 57, 74, 40, 85, 61};
        int min = 99999999;
        int minindex = 0;
        int max = 0;
        int maxindex = 0;
        for (int i = 0; i < num.length; i++) {


            if (num[i] < min) {
                min = num[i];
                minindex = i;
            }
            if (num[i] > max) {
                max = num[i];
                maxindex = i;
            }
            }
        System.out.println("최대값 : "+max+",인덱스 : "+ (maxindex+1));
        System.out.println("최소값 : "+min+",인덱스 : "+ (minindex+1));
    }
}
