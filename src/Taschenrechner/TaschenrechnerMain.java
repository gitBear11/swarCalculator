package Taschenrechner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public class TaschenrechnerMain {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> calculation = new ArrayList<>();
        PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
        String input = "n";


        Scanner eingabe = new Scanner(System.in);

        Pattern correctInput = Pattern.compile("((-?\\d+\\.?\\d*)((\\+||\\-||\\*||\\/)( )*(-?\\d+\\.?\\d*))+)");


        while (input.equals("n")) {
            System.out.println("Geben Sie ihre Rechnung ein");
            input = eingabe.nextLine();

            input = input.replaceAll("\\s", "");


            Matcher m = correctInput.matcher(input);

            if (m.matches()) {

                String[] singleChar = input.split("");
                calculation = createList(singleChar);

                calculation = lineFirst(calculation);
                calculation = dotOperations(calculation);

                String result = calculation.get(calculation.size() - 1);
                System.out.println(result);
                writer.println(result);

                System.out.println("Wollen Sie beenden? (y/n)");
                input = eingabe.nextLine();


            } else {
                System.out.println("Ihre Eingabe war falsch");
            }

        }
        writer.close();
    }

    public static List lineFirst(List<String> calculation){

        int j = 0;
        double x = 0.0;
        double y = 0.0;
        List<String> calculationLine = new ArrayList<>();

        for (int i = 0; i <= calculation.size() - 1; i++) {

            switch (calculation.get(i)) {
                case "*":
                    j = calculationLine.size() - 1;
                    x = Double.parseDouble(calculation.get(i - 1));
                    y = Double.parseDouble(calculation.get(i + 1));

                    String resultMul = Double.toString(Operations.mul(x, y));

                    calculation.set(i + 1, resultMul);
                    calculationLine.set(j, resultMul);
                    i++;
                    ;

                    break;
                case "/":
                    j = calculationLine.size() - 1;
                    x = Double.parseDouble(calculation.get(i - 1));
                    y = Double.parseDouble(calculation.get(i + 1));

                    String resultDiv = Double.toString(Operations.divide(x, y));

                    calculation.set(i + 1, resultDiv);
                    calculationLine.set(j, resultDiv);
                    i++;
                default:
                    calculationLine.add(calculation.get(i));
                    break;
            }

        } return calculationLine;
    }
    public static List dotOperations(List<String> calculationLine){

        int j = 0;
        double x = 0.0;
        double y = 0.0;

        for (int i = 0; i < calculationLine.size(); i++) {
            switch (calculationLine.get(i)) {
                case "+":

                    x = Double.parseDouble(calculationLine.get(i - 1));
                    y = Double.parseDouble(calculationLine.get(i + 1));

                    String resultAdd = Double.toString(Operations.add(x, y));
                    calculationLine.set(i + 1, resultAdd);
                    i++;
                    ;

                    break;
                case "/":
                    x = Double.parseDouble(calculationLine.get(i - 1));
                    y = Double.parseDouble(calculationLine.get(i + 1));

                    String resultSubb = Double.toString(Operations.subb(x, y));
                    calculationLine.set(i + 1, resultSubb);
                    i++;
            }


        } return calculationLine;
    }
    public static List createList(String[] stringArray) {

        List<String> calculation = new ArrayList<>();
        int j = 0;
        StringBuilder number = new StringBuilder("");


        for (j = 0; j < stringArray.length; j++) { //bis zum Operation durch gehen

            if (stringArray[j].equals("+") || stringArray[j].equals("/") || stringArray[j].equals("*") || stringArray[j].equals("-")) {
                calculation.add(number.toString());
                number = new StringBuilder();
                calculation.add(stringArray[j]);

            } else {
                number.append(stringArray[j]);
            }

        }

        calculation.add(number.toString());
        return calculation;

    }
}

