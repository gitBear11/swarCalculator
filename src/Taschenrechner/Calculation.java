package Taschenrechner;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
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
}
