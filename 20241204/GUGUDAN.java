package basic.condition;

public class GUGUDAN {
    public static void main(String[] args) {
        System.out.println("=== 구구단 ===");
        // cjt for는 단을 출력하는 용도
        for (int i =2; i <=9; i++){
            System.out.println("---" + i + "단---");
            // 두번재 for는 매 단마다 곱할 수를 표현
            for (int j = 1; j <=9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
}
