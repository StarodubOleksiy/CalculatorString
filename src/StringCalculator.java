import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.HashSet;
import java.io.IOException;

/**
 * Created by Администратор on 18.05.16.
 */
public class StringCalculator {
    private HashSet<Character> numbers;
    private Deque<String> stack;

    private void creatingInnerStack()throws  IOException
    {

        Deque<String> anotherStack = new LinkedList<String>();
        while(true)
        {
            String tempvalue = stack.pop();
            if(tempvalue.equals(")"))
                break;
            anotherStack.add(tempvalue);
            if(stack.size()<1 ||stack.isEmpty())
                throw new IOException("You have forgot to put the closing bracket");
        }
        stack.push(outputResult(anotherStack));
    }


    private String outputResult(Deque<String> stack) throws IOException
    {
        if(stack.getFirst().equals("-") ) {
            stack.pop();
            Double value = Double.parseDouble(stack.pop()) * (-1);
            String negativeValue = "";
            negativeValue += value;
            stack.push(negativeValue);
        }
        while(stack.size() > 1) {
            String firstvalue = stack.pop();
            String operator = stack.pop();
            if(firstvalue.equals("("))
            {
                stack.push(operator);
                creatingInnerStack();
            } else
            if (stack.getFirst().equals("(")) {
                stack.pop();
                creatingInnerStack();
                stack.push(operator);
                stack.push(firstvalue);
            } else {
            if((operator.equals("+")||operator.equals("-"))&&stack.size()>1)
                {
                    String nextvalue = stack.pop();
                    String nextoperator = stack.pop();
                    if(nextoperator.equals("*")||nextoperator.equals("/"))
                    {
                        if(stack.getFirst().equals("("))
                        {
                            stack.pop();
                            creatingInnerStack();
                            stack.push(nextoperator);
                            stack.push(nextvalue);
                            stack.push(operator);
                            stack.push(firstvalue);
                            continue;
                        }
                        else {
                            stack.push(solve(nextvalue, nextoperator, stack.pop()));
                            stack.push(operator);
                            stack.push(firstvalue);
                            continue;
                        }
                    } else
                    {
                        stack.push(nextoperator);
                        stack.push(nextvalue);
                    }
                }
                stack.push(solve(firstvalue, operator, stack.pop()));
            }
        }
        return stack.pop();
    }

    private String solve(String firstValue, String operator, String lastValue) throws IOException
    {
        String result = "";
        if(operator.equals("+")) {
            Double doubleResult = Double.parseDouble(firstValue)+Double.parseDouble(lastValue);
            result +=doubleResult;
        }  else if  (operator.equals("-")) {
            Double doubleResult = Double.parseDouble(firstValue)-Double.parseDouble(lastValue);
            result +=doubleResult;
        }  else if  (operator.equals("*")) {
            Double doubleResult = Double.parseDouble(firstValue)*Double.parseDouble(lastValue);
            result +=doubleResult;
        }
        else if  (operator.equals("/")) {
            if(lastValue.equals("0"))
                throw new ArithmeticException("Divide by zero is forbidden");

            Double doubleResult = Double.parseDouble(firstValue)/Double.parseDouble(lastValue);
            result +=doubleResult;
        }
        else if  (operator.equals("^")) {
            Double doubleResult = Math.pow(Double.parseDouble(firstValue),Double.parseDouble(lastValue));
            result +=doubleResult;
        }else throw new IOException("you entered the wrong operator !!!");
        return result;
    }



    public StringCalculator() {
        numbers = new HashSet<Character>();
        stack = new LinkedList<String>();
        for (char i = '0'; i < '9' + 1; ++i)
            numbers.add(i);
        numbers.add('.');
      }



    public String calculateString(String input) throws  IOException
    {
        boolean isNumber = false;
        char someArray[] = input.toCharArray();
        int numberBegin = 0;
        int numberEnd;

        for (int i = 0; i < someArray.length; ++i) {
            if(numbers.contains(someArray[i]) && isNumber == false )
            {
                numberBegin = i;
                isNumber = true;
            }

            if(!numbers.contains(someArray[i]) && isNumber == true )
            {
                numberEnd = i;
                isNumber = false;
                StringBuilder number = new StringBuilder();
                number.append(someArray,numberBegin,numberEnd-numberBegin);
                stack.add(number.toString());
            }
            if(!isNumber) {
                String operator = "";
                operator += someArray[i];
                stack.add(operator);
            }
        }
        if(isNumber == true )
        {
            StringBuilder number = new StringBuilder();
            number.append(someArray,numberBegin,someArray.length-numberBegin);
            stack.add(number.toString());
        }
        return outputResult(stack);
    }
}
