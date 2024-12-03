package basic.exam;

public class 문제5 {
    public static void main(String[] args) {
        int Money = 3780;
        System.out.println("1000원 : " + Money / + 1000 + "개");
        Money = Money % 1000;
        System.out.println("500원 : " + Money / + 500 + "개");
        System.out.println("남은금액 : "+ Money % + 500 + "원");
        Money = Money % 500;
        System.out.println("100원 : "+ Money/ + 100 + "개");
        System.out.println("남은금액 : "+ Money % + 100 + "원");
        Money = Money % 100;
        System.out.println("10원 : "+Money / + 10 + "개");
        System.out.println("남은금액 : "+ Money % + 10 + "원");



    }
}
