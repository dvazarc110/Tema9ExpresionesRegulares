package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio6Sergio {
  public void show() {
    String text = """
        Ecuaciones de primer grado con una incógnita. Veamos algunos ejemplos válidos y no válidos:

        Ejercicio1: x=3+13
        Ejercicio2: 8+70=x
        Ejercicio3: 2-x=x-8
        Ejercicio4: x-1+x+3=2+x+8-x
        Ejercicio5: 4+x-3-x+1+x=x+x+x-1-1

        No vale: ++x-3=x+6
        No vale: x++5=8+x
        No vale: x=--x
        No vale: 3-1+x=-4+6--x
        """;

    Matcher equationsMatch = getEquations(text);

    while (equationsMatch.find()) {
      System.out.printf("%-21s   Solución: %d\n", equationsMatch.group(1), calcEquation(equationsMatch.group(1)));
    }
  }

  public Matcher getEquations(String text) {
    Pattern pattern = Pattern.compile("^.+:\\s+((x|[0-9]+)([+-](x|[0-9]+))*=(x|[0-9]+)([+-](x|[0-9]+))*)$",
        Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(text);
    return matcher;
  }

  public int calcEquation(String equation) {
    String[] splittedEquation = equation.split("=");
    String leftSide = splittedEquation[0];
    String rightSide = splittedEquation[1];

    Pattern xPattern = Pattern.compile("-?x");
    Matcher leftXMatcher = xPattern.matcher(leftSide);
    Matcher rightXMatcher = xPattern.matcher(rightSide);
    Pattern totalPattern = Pattern.compile("-?[0-9]+");
    Matcher leftTotalMatcher = totalPattern.matcher(leftSide);
    Matcher rightTotalMatcher = totalPattern.matcher(rightSide);

    int leftXCount = getXCount(leftXMatcher);
    int rightXCount = getXCount(rightXMatcher);
    int leftTotal = getTotalCalc(leftTotalMatcher);
    int rightTotal = getTotalCalc(rightTotalMatcher);

    int totalX = leftXCount - rightXCount;
    int totalCalc = rightTotal - leftTotal;
    int result = totalCalc / totalX;

    return result;
  }

  public int getXCount(Matcher matcher) {
    int count = 0;
    String match = "";

    while (matcher.find()) {
      match = matcher.group();

      if (match.equals("x")) {
        count++;
      } else {
        count--;
      }
    }

    return count;
  }

  public int getTotalCalc(Matcher matcher) {
    int total = 0;
    String match = "";

    while (matcher.find()) {
      match = matcher.group();

      total += Integer.parseInt(match);
    }

    return total;
  }

  public static void main(String[] args) {
    new Ejercicio6Sergio().show();
  }
}
