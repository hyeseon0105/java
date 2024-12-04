package basic.condition;

public class IfCondition {
    public static void main(String[] args) {
        // 조건 판단문 : if
        //1. 점수 60점 이상 : 합격, 불합격
        // if(조건) {
        //     참일때 실행할 문자 }
        // else {
        //     거짓일 때 실행할 문자 }
        int score = 100;
//        score >= 60 ? "합격" ; "불합격";
        if (score >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
        if (score >= 90) {
            System.out.println("수");
        }else if (score >= 80) {
            System.out.println("우");
        } else if (score >= 70) {
            System.out.println("미");
        }else if (score >= 60) {
            System.out.println("양");
        }else {
                            System.out.println("가");
                        }}}



