package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuebasExercise7 {

	public void show() {
		
		Pattern pattern, patternnum, patternincog;
        Matcher matcher;
        int num, resultnum, resultincog, resultfin;
		int resultincog1 = 0;
		int resultincog2 = 0;
        int resultnum1 = 0;
        int resultnum2 = 0;
        
		String ecuacion = "4+x-13-x+1+x=x+x+x-1-1";
		String expresion1 = ecuacion.substring(0, ecuacion.indexOf("="));
		String expresion2 = ecuacion.substring(ecuacion.indexOf("=")+1);
		
		System.out.println("Antes:");
		System.out.println(expresion1 + " " + expresion1.length());
		System.out.println(expresion2 + " " + expresion2.length());
		
		if(expresion1.substring(0,1)!= "-") {
			if(expresion1.substring(0,1)!= "+") {
				expresion1 = "+".concat(expresion1);
			}
		}
		for(int i = 1; i < expresion1.length(); i++) {
			if(expresion1.charAt(i) == '-' || expresion1.charAt(i) == '+') {
				expresion1 = (expresion1.substring(0, i)).concat("\n".concat(expresion1.substring(i)));
				i++;
			}
		}
		if(expresion2.substring(0,1)!= "-") {
			if(expresion2.substring(0,1)!= "+") {
				expresion2 = "+".concat(expresion2);
			}
		}
		for(int i = 1; i < expresion2.length(); i++) {
			if(expresion2.charAt(i) == '-' || expresion2.charAt(i) == '+') {
				expresion2 = (expresion2.substring(0, i)).concat("\n".concat(expresion2.substring(i)));
				i++;
			}
		}
		System.out.println("Después:");
		System.out.println(expresion1 + " " + expresion1.length());
		System.out.println(expresion2 + " " + expresion2.length());
		
		
		System.out.println("General:");
        pattern = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?$", Pattern.MULTILINE);
        matcher = pattern.matcher(expresion1);
        while (matcher.find()) {
			System.out.printf("Reluctant: coincidencia desde %d hasta %d\n", matcher.start(),
					matcher.end() - 1);
		}
        
        
        System.out.println("Solo números:");
        patternnum = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Digit}]+?))*?$", Pattern.MULTILINE);
        matcher = patternnum.matcher(expresion1);
        while (matcher.find()) {
			System.out.printf("Reluctant: coincidencia desde %d hasta %d\n", matcher.start(),
					matcher.end() - 1);
			System.out.println(matcher.group(2) + " " + matcher.group(3));
			num = Integer.parseInt(matcher.group(3));
			System.out.println(num);
			if(matcher.group(2).equalsIgnoreCase("+")) {
				resultnum1 = resultnum1 + num;
			}else if(matcher.group(2).equalsIgnoreCase("-")) {
				resultnum1 = resultnum1 - num;
			}
			System.out.println(resultnum1);
			
		}
        System.out.println("Solo incógnitas:");
        patternincog = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]))*?$", Pattern.MULTILINE);
        matcher = patternincog.matcher(expresion1);
        while (matcher.find()) {
			System.out.printf("Reluctant: coincidencia desde %d hasta %d\n", matcher.start(),
					matcher.end() - 1);
			System.out.println(matcher.group(3));
			if(matcher.group(2).equalsIgnoreCase("-")) {
				resultincog1 = resultincog1 + 1;
			}else if(matcher.group(2).equalsIgnoreCase("-")) {
				resultincog1 = resultincog1 - 1;
			}
			System.out.println(resultincog1 + "x");
		}
        System.out.println(resultnum1);
        System.out.println(resultincog1 + "x");
        
        System.out.println("General:");
        pattern = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?$", Pattern.MULTILINE);
        matcher = pattern.matcher(expresion2);
        while (matcher.find()) {
			System.out.printf("Reluctant: coincidencia desde %d hasta %d\n", matcher.start(),
					matcher.end() - 1);
		}
        
        
        System.out.println("Solo números:");
        patternnum = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Digit}]+?))*?$", Pattern.MULTILINE);
        matcher = patternnum.matcher(expresion2);
        while (matcher.find()) {
			System.out.printf("Reluctant: coincidencia desde %d hasta %d\n", matcher.start(),
					matcher.end() - 1);
			System.out.println(matcher.group(2) + " " + matcher.group(3));
			num = Integer.parseInt(matcher.group(3));
			System.out.println(num);
			if(matcher.group(2).equalsIgnoreCase("+")) {
				resultnum2 = resultnum2 + num;
			}else if(matcher.group(2).equalsIgnoreCase("-")) {
				resultnum2 = resultnum2 - num;
			}
			System.out.println(resultnum2);
			
		}
        System.out.println("Solo incógnitas:");
        patternincog = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]))*?$", Pattern.MULTILINE);
        matcher = patternincog.matcher(expresion2);
        while (matcher.find()) {
			System.out.printf("Reluctant: coincidencia desde %d hasta %d\n", matcher.start(),
					matcher.end() - 1);
			System.out.println(matcher.group(3));
			if(matcher.group(2).equalsIgnoreCase("+")) {
				resultincog2 = resultincog2 + 1;
			}else if(matcher.group(2).equalsIgnoreCase("-")) {
				resultincog2 = resultincog2 - 1;
			}
			System.out.println(resultincog2 + "x");
		}
        System.out.println(resultnum2);
        System.out.println(resultincog2 + "x");
        
        System.out.println("\n" + resultnum1 + " " + resultnum2);
        System.out.println("\n" + resultincog1 + "x " + resultincog2 + "x");
        
        resultnum = resultnum2 + (resultnum1*(-1));
        resultincog = resultincog1 + (resultincog2*(-1));
        System.out.println("\n" + resultnum);
        System.out.println("\n" + resultincog + "x");
        
        resultfin = resultnum/resultincog;
        System.out.println("x = " + resultfin);
	}
	
	public static void main(String[] args) {

		new PuebasExercise7().show();
		
	}

}
