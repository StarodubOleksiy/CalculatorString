



public class Main {


    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

       String someString1 = "7+2*(500+600*4)";
        String someString2 = "8+9+2*(1000+4000)";
       String someString3 = "456.32+685.32*874.21-987.21+654.1254/0.21456";
        String someString4 = "4*4+2+2*2+2*2+3*3";
        String someString5 = "123.12+34*(12-10)";
        String someString6 = "2+2*2+3*3";
        String someString7 = "2+2*(2+3*3)";
        String someString8 = "2+2*(2+3*3)+6+7";
        String someString9 = "2*(2+3*3)*(6+7)";
        String someString10 = "-2+(2+3*3)*(6+7)";


          System.out.println("result someString1 = "+calculator.calculateString(someString1));
        System.out.println("result someString2 = "+calculator.calculateString(someString2));
        System.out.println("result someString3 = "+calculator.calculateString(someString3));
        System.out.println("result someString4 = "+calculator.calculateString(someString4));
        System.out.println("result someString5 = "+calculator.calculateString(someString5));
        System.out.println("result someString6 = "+calculator.calculateString(someString6));
        System.out.println("result someString7 = "+calculator.calculateString(someString7));
        System.out.println("result someString8 = "+calculator.calculateString(someString8));
        System.out.println("result someString9 = "+calculator.calculateString(someString9));
        System.out.println("result someString10 = "+calculator.calculateString(someString10));

    }
}