import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{
        StringCalculator calculator = new StringCalculator();
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        String someString11 = "(2+3*3)*6+7";
        String someString12 = "6+(-5)+9+(-7)";
        String someString13 = "(2+3*3)*(6+7)";
        String someString14 = "2+3*8+(6+7)";
        String someString15 = "2+3*8+(6*7)";
        String someString16 = "2+2*2";
        String someString17 = "(2+2)*2";
        String someString18 = "1/2+1/4";
        String someString19 = "(3+3)*(12-3)";
        String someString20 = "2502.43+958.65+342.38";

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
        System.out.println("result someString11 = "+calculator.calculateString(someString11));
        System.out.println("result someString12 = "+calculator.calculateString(someString12));
        System.out.println("result someString13 = "+calculator.calculateString(someString13));
        System.out.println("result someString14 = "+calculator.calculateString(someString14));
        System.out.println("result someString15 = "+calculator.calculateString(someString15));
        System.out.println("result someString16 = "+calculator.calculateString(someString16));
        System.out.println("result someString17 = "+calculator.calculateString(someString17));
        System.out.println("result someString18 = "+calculator.calculateString(someString18));
        System.out.println("result someString19 = "+calculator.calculateString(someString19));
        System.out.println("result someString20 = "+calculator.calculateString(someString20));


     String input = new String();
     do {
      System.out.println("Enter the string which you want to calculate or exit if you want to exit the program");
      System.out.println("Input = ");
      input = reader.readLine().toLowerCase();
      if(input.equals("exit"))
       break;
      System.out.println("result is: ");

      System.out.println(input+"="+calculator.calculateString(input));

     }while(true);


    }
}
