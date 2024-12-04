package basic.myPagage;

public class OperationEx2 {
    public static void main(String[] args) {
        final double PI = 3.14;
        // PI = 4
        //1. a에 10을 넣는다.
        int a = 8;
        //2. b에 20을 넣는다.
        long b = 20;
        //3. a와 b를 더해서 출력한다.
        System.out.println(a + b);

        //4. b의값을 5로 변경
        b = 5;
        //5. a와 b를 곱해서 출력
        long x = a * b;
        System.out.println("a*b = " + x);
        // a 나누기 b = 결과를 result 에 담아서 출력
        double result = (double) a / b;
        System.out.println("a / b =" + result );
        // numberA = 3
        int numberA = 3;
        // numberB = 7
        int numberB = 7;
        // 3 나누기 7로 나눈 나머지
        int number = numberA % numberB;
        // 결과를 answer에 담아서 출력
        int anaswer = numberA % numberB;
        System.out.println(numberA + "을 " +
                numberB + "로 나눈 나머지는? " +
                anaswer + "입니다.");


    }
}


