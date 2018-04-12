package Taschenrechner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public class TaschenrechnerMain {
    public static void main(String[] args) {
        List<String> calculation = new ArrayList<>();
        Scanner eingabe = new Scanner(System.in);
        StringBuilder sb;
        int j = 0;

        Pattern correctInput = Pattern.compile("((-?\\d+\\.?\\d*)((\\+||\\-||\\*||\\/)( )*(-?\\d+\\.?\\d*))+)");
        Pattern isNumber = Pattern.compile("-?\\d+\\.\\d+");
        //Pattern isOperation = Pattern.compile("\\")


        System.out.println("Geben Sie ihre Rechnung ein");

        String input = eingabe.nextLine();


        input = input.replaceAll("\\s", "");


        Matcher m = correctInput.matcher(input);

        if (m.matches()) {

            String[] zeichen = input.split("");
            String[] mergedArray = new String[input.length()];
            StringBuilder number = new StringBuilder("");


            for (j = 0; j < zeichen.length; j++) { //bis zum Operation durch gehen

                if (zeichen[j].equals("+") || zeichen[j].equals("/") || zeichen[j].equals("*") || zeichen[j].equals("-")) {
                    calculation.add(number.toString());
                    number = new StringBuilder();
                    calculation.add(zeichen[j]);

                } else {
                    number.append(zeichen[j]);
                }

            }
            calculation.add(number.toString());

            System.out.println(calculation);

        } else {
            System.out.println("fehler");
        }

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



