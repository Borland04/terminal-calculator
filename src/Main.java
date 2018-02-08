import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, Integer> priorityMap;

    static {
        priorityMap = new HashMap<>(6);
        priorityMap.put("+", 1);
        priorityMap.put("-", 1);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);
        priorityMap.put("^", 3);
        priorityMap.put("(", 10);
        priorityMap.put(")", 10);
    }


    public static void main(String[] args) {
        Reader r = new InputStreamReader(System.in);
        while (true) {
            try (BufferedReader input = new BufferedReader(r)) {
                String expression = input.readLine();
                expression = expression.replace(',', '.');

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static BigDecimal calculate(String expression) {

    }

    public static String nextAtom(String str, int startIndex) {
        if(startIndex >= str.length()) {
            return "";
        }

        str = str.substring(startIndex).trim();
        if(str.length() == 0) {
            return "";
        }

        // If next atom is number (1 or 0.324)
        if(Character.isDigit(str.charAt(0))) {
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

    public static boolean isOperator(String str) {
        for (String op : priorityMap.keySet()) {
            if (op.equals(str)) {
                return true;
            }
        }

        return false;
    }

}
