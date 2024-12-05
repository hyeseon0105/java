package sort;


    public class 문제1 {
        public static void main(String[] args) {
            int[] arr = {3, 29, 38, 12, 57, 74, 40, 85, 61};
            int max = arr[0];
            int maxindex = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxindex = i;
                }
            }
            System.out.println("최댓값 : "+ max);
            System.out.println("최댓값 인덱스 : "+ maxindex);

            int[] Array = {3, 29, 38, 12, 57, 74, 40, 85, 61};
            int min = Array[0];
            int minindex = 0;

            for (int j = 0; j < Array.length; j++) {
                if (Array[j] < min) {
                    min = Array[j];
                    minindex = j;
                }
            }
            System.out.println("최소값 : "+ min);
            System.out.println("최소값 인덱스 : "+ minindex);

        }
    }
