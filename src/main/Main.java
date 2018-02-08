package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;


public class Main {

    private static Map<String, Integer> priorityMap;
    private static Map<String, BinaryOperator<BigDecimal>> expressionMap;

    static {
        priorityMap = new HashMap<>(7);
        priorityMap.put("+", 1);
        priorityMap.put("-", 1);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);
        priorityMap.put("^", 3);
        priorityMap.put("(", 10);
        priorityMap.put(")", 10);
        
        expressionMap = new HashMap<>(5);
        expressionMap.put("+", BigDecimal::add);
        expressionMap.put("-", BigDecimal::subtract);
        expressionMap.put("*", BigDecimal::multiply);
        expressionMap.put("/", (a, b) -> {
            if(b.intValue() == 0) {
                throw new InvalidDataException("Divide by zero");
            }
            return a.divide(b);
        });
        expressionMap.put("^", (a, b) -> a.pow(b.intValueExact()));
    }


    public static void main(String[] args) {
        Reader r = new InputStreamReader(System.in);
        while (true) {
            try (BufferedReader input = new BufferedReader(r)) {
                String expression = input.readLine();
                expression = expression.replace(',', '.');
                BigDecimal result = calculate(expression);
                System.out.println("result: " + result.toString());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArithmeticException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static BigDecimal calculate(String expression) {
        Stack<BigDecimal> operands = new Stack<>();
        Stack<String> operators = new Stack<>();




        return new BigDecimal(0);
    }

    public static String nextAtom(String str, int startIndex) {
        if(startIndex >= str.length()) {
            return "";
        }

        str = str.substring(startIndex).trim();
        if(str.length() == 0) {
            return "";
        }

        // If next atom is number (1, -2 or 0.324)
        boolean isNegativeNumber = str.length() > 1 && str.charAt(0) == '-' && Character.isDigit(str.charAt(1));
        if(isNegativeNumber || Character.isDigit(str.charAt(0))) {
            int length = 1;
            while(length < str.length() &&
                    (Character.isDigit(str.charAt(length)) || str.charAt(length) == '.')) {
                length++;
            }
            return str.substring(0, length);
        // If next atom is Operator or smth unknown(*, + or abcdf)
        } else {
            int length = 1;
            while(length < str.length() &&
                    !Character.isDigit(str.charAt(length)) &&
                    !Character.isWhitespace(str.charAt(length))) {
                length++;
            }
            return str.substring(0, length);
        }
    }

    public static BigDecimal calculateExpression(String operator, Stack<BigDecimal> stack) {
        if(stack.size() < 2) {
            throw new InvalidDataException("Not enough operands for " + operator + " operator");
        }

        BigDecimal a = stack.pop();
        BigDecimal b = stack.pop();

        BinaryOperator op = expressionMap.getOrDefault(operator,
                (bd1, bd2) -> {
            throw new InvalidDataException("Unknown operator " + operator);
        });

        return (BigDecimal) op.apply(b, a);
    }

    public static boolean isOperator(String str) {
        for (String op : priorityMap.keySet()) {
            if (op.equals(str)) {
                return true;
            }
        }

        return false;
    }

    public static Integer getPriorityOrMinus1(String operator) {
        return priorityMap.getOrDefault(operator, -1);
    }

}
