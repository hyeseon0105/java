package basic.exam;

public class 문제7 {
    public static void main(String[] args) {
        int intA = 0;
        int intB = 0;
        intA = intA + 2;
        intB = intB + intA;
        intA = intA + 1;
        intB = intB + intA;
        intA = intA + 1;
        intB = intB + intA;
        intA = intA + 1;
        intB = intB + intA;
        intA = intA + 1;
        intB = intB + intA;
        intA = intA + 1;
        intB = intB + intA;

        System.out.println(intB);

        intB = 0;
        for (int i = 2; i <= 7 ; i ++) {
            intB = intB + i;
        }
        System.out.println(intB);
    }
}
