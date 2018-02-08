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
        while(true) {
            try (BufferedReader input = new BufferedReader(r)) {
                String expression = input.readLine();
                expression = expression.replace(',', '.');

            } catch (IOException e) {
                e.printStackTrace();
            } catch(InvalidDataException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static BigDecimal calculate(String expression) {

    }

    public static String getAtom(String str, int startIndex) {

    }

    public static boolean isOperator(String str) {

    }

}
