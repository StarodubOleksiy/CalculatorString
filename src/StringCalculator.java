import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Администратор on 18.05.16.
 */
public class StringCalculator {
    ArrayList<Character> numbers = new ArrayList<Character>();

    boolean numberValidator(char digit) {
        boolean isNumber;
        if (numbers.contains(digit))
            isNumber = true;
        else
            isNumber = false;
        return isNumber;
    }




    StringCalculator() {
        for (char i = '0'; i < '9' + 1; ++i)
            numbers.add(i);
        numbers.add('.');

    }
    private Deque<String> creatingInnerStack()
    {

        Deque<String> anotherStack;
        anotherStack = creatingInnerStack();
        return anotherStack;

    }
    private String outputResult(Deque<String> stack)
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
                Deque<String> anotherStack = new LinkedList<String>();
                while(true)
                {
                    String tempvalue = stack.pop();
                    if(tempvalue.equals(")"))
                        break;
                    anotherStack.add(tempvalue);
                    if(stack.size()<1)
                        throw new ArithmeticException();
                }
                stack.push(outputResult(anotherStack));
            } else
            if (stack.getFirst().equals("(")) {
                Deque<String> anotherStack = new LinkedList<String>();
                stack.pop();
                while(true)
                {
                    String tempvalue = stack.pop();
                    if(tempvalue.equals(")"))
                        break;
                    anotherStack.add(tempvalue);
                    if(stack.size()<1)
                        throw new ArithmeticException();
                }

                stack.push(outputResult(anotherStack));
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
                            Deque<String> anotherStack = new LinkedList<String>();
                            stack.pop();
                            while(true)
                            {
                                String tempvalue = stack.pop();
                                if(tempvalue.equals(")"))
                                    break;
                                anotherStack.add(tempvalue);
                                if(stack.size()<1)
                                    throw new ArithmeticException();
                            }
                            stack.push(outputResult(anotherStack));
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
        } //End while(1)
        return stack.pop();
    }

    private String solve(String firstValue, String operator, String lastValue)
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
            Double doubleResult = Double.parseDouble(firstValue)/Double.parseDouble(lastValue);
            result +=doubleResult;
        }
        return result;
    }

    private Deque<String> stack = new LinkedList<String>();

    public String calculateString(String input)
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