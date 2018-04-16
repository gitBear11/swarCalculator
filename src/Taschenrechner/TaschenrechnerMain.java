package Taschenrechner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaschenrechnerMain {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> calculation;
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

                calculation = Calculation.lineFirst(calculation);
                calculation = Calculation.dotOperations(calculation);

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


    private static List createList(String[] stringArray) {

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

