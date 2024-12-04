package basic.condition;

public class CompareNumber {
    public static void main(String[] args) {
        int intA = 7 ;
        int intB = 4 ;
        String testString ;
        int temp;
        String resulit = "intA = " + intA + ", intB = " + intB;
        System.out.println(resulit);
        if (intA < intB){
            temp = intA;
            intA = intB;
            intB = temp;
        }
        resulit = "intA = " + intA + ", intB = " + intB;
        System.out.println(resulit);






    }
}
