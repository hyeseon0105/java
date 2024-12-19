package lambda;

public class LambdaExpression {
    //자바스크립트 : =>
    public static void main(String[] args) {
        Calc add = (x, y) -> {
            return x + y;
        };
        Calc minus = (x, y) -> x - y;
        System.out.println(add.calculator(3, 4));
        System.out.println(minus.calculator(7,3));
    }
}
