package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio6Aidan {
	public void exercise6() {
		Pattern pattern = Pattern.compile("([-+]*[0-9x\\-+]+=[0-9x\\-+]+)");
		Matcher matcher = pattern.matcher("""
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
				""");
		while (matcher.find()) {
			if (isValid(matcher.group(1))) {
				printResult(String.format("%s\tSolución: %d", matcher.group(1),calculateEcuation(matcher)));
			}
		}
	}
	public boolean isValid(String validate) {
		if (validate.contains("++")||validate.contains("--")) {
			return false;
		} else {
			return true;
		}
	}
	public int calculateEcuation(Matcher matcher) {
		int result = 0,count,leftResult,rightResult;
		StringBuilder leftString, rightString;
		count = matcher.group(1).indexOf('=');
		leftString = new StringBuilder(matcher.group(1).substring(0, count));
		rightString = new StringBuilder(matcher.group(1).substring(count+1));
		leftToRight(leftString,rightString);
		rightToLeft(leftString,rightString);
		cleanLeft(leftString);
		cleanRight(rightString);
		leftResult = resultLeft(leftString);
		rightResult = resultRight(rightString);
		result = rightResult/leftResult;
		return result;
	}
	public void leftToRight(StringBuilder leftString, StringBuilder rightString) {
		if ((-seekPositives(leftString) + seekNegatives(leftString))>0) {
			rightString.append("+"+(-seekPositives(leftString) + seekNegatives(leftString)));
		} else if((-seekPositives(leftString) + seekNegatives(leftString))<0) {
			rightString.append(-seekPositives(leftString) + seekNegatives(leftString));
		}
	}
	public void rightToLeft(StringBuilder leftString, StringBuilder rightString) {
		for (int i = 0; i<seekPositivesX(rightString);i++) {
			leftString.append("-x");
		}
		for (int i = 0; i<seekNegativesX(rightString);i++) {
			leftString.append("+x");
		}
	}
	public int seekPositives(StringBuilder direction) {
		int resultPositives = 0;
		Pattern patternPositive = Pattern.compile("([\\-]*[0-9]+)");
		Matcher matcher = patternPositive.matcher(direction);
		while (matcher.find()) {
			if (Integer.parseInt(matcher.group(1)) > 0) {
				resultPositives+= Integer.parseInt(matcher.group(1));
			}
		}
		return resultPositives;
	}
	public int seekNegatives(StringBuilder direction) {
		int resultNegatives = 0;
		Pattern patternPositive = Pattern.compile("\\-([0-9]+)");
		Matcher matcher = patternPositive.matcher(direction);
		while (matcher.find()) {
			resultNegatives+= Integer.parseInt(matcher.group(1));
		}
		return resultNegatives;
	}
	public int seekPositivesX(StringBuilder direction) {
		int count=0;
		Pattern patternPositiveX = Pattern.compile("([\\-]*x)");
		Matcher matcher = patternPositiveX.matcher(direction);
		while (matcher.find()) {
			if (matcher.group(1).length() == 1) {
				count++;
			}
		}
		return count;
	}
	public int seekNegativesX(StringBuilder direction) {
		int count=0;
		Pattern patternNegativeX = Pattern.compile("(\\-x)");
		Matcher matcher = patternNegativeX.matcher(direction);
		while (matcher.find()) {
			count++;
		}
		
		return count;
	}
	public void cleanLeft(StringBuilder direction) {
		direction.replace(0,direction.length(),direction.toString().replaceAll("[\\+\\-]*[0-9]", ""));
	}
	public void cleanRight(StringBuilder direction) {
		direction.replace(0,direction.length(),direction.toString().replaceAll("[\\+\\-]*x", ""));
	}
	public int resultRight(StringBuilder direction) {
		return seekPositives(direction) - seekNegatives(direction);
	}
	public int resultLeft(StringBuilder direction) {
		return seekPositivesX(direction) - seekNegativesX(direction);
	}
	public void printResult(String mensaje) {
		System.out.println(mensaje);
	}
	public static void main(String[] args) {
		new Ejercicio6Aidan().exercise6();
	}
}
