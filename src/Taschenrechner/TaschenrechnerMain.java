package Taschenrechner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public class TaschenrechnerMain {
    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        Pattern correctInput = Pattern.compile("((-?\\d+\\.?\\d*)((\\+||\\-||\\*||\\/)( )*(-?\\d+\\.?\\d*))+)");

        System.out.println("Geben Sie ihre Rechnung ein");
        String input = eingabe.nextLine();

        input = input.replaceAll("\\s", "");


        Matcher m = correctInput.matcher(input);

        if (m.matches()) {

            String[] singleChar = input.split("");
            createList(singleChar);

        } else {

        }

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


    public static void findDotOperation(String[] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            switch (stringArray[i]) {
                case "*":

            }

            if (stringArray[i].equals('*') || stringArray[i].equals('*')) {

            }
        }
    }

}



