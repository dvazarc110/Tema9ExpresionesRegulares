package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Exercise7v2 {

	public void show() {

		Scanner keyboard = new Scanner(System.in);
		ConsoleInput consola = new ConsoleInput(keyboard);
		Pattern pattern, patternnum, patternincog;
		Matcher matcher, matcher2;
		String inputecua, ecuacion, expresion1, expresion2;
		int num, resultnum, resultincog, resultfin;
		int resultincog1 = 0;
		int resultincog2 = 0;
		int resultnum1 = 0;
		int resultnum2 = 0;

		do {
			System.out.println("Introduzca una ecuación de primer grado:");
			inputecua = (consola.readString()).trim();
		}while(inputecua.isBlank());
		
		//pattern = Pattern.compile("^(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?=(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?$", Pattern.MULTILINE);
		pattern = Pattern.compile("^(([\\p{Punct}&&[-+]]??)([\\p{Digit}]+?|(([\\p{Digit}]*?[\\p{Lower}&&[x]])|([\\p{Lower}&&[x]][\\p{Digit}]*?)))){1}?(([\\p{Punct}&&[-+]])([\\p{Digit}]+?|(([\\p{Digit}]*?[\\p{Lower}&&[x]])|([\\p{Lower}&&[x]][\\p{Digit}]*?))))*?=(([\\p{Punct}&&[-+]]??)([\\p{Digit}]+?|(([\\p{Digit}]*?[\\p{Lower}&&[x]])|([\\p{Lower}&&[x]][\\p{Digit}]*?)))){1}(([\\p{Punct}&&[-+]])([\\p{Digit}]+?|(([\\p{Digit}]*?[\\p{Lower}&&[x]])|([\\p{Lower}&&[x]][\\p{Digit}]*?))))*?$", Pattern.MULTILINE);
		matcher = pattern.matcher(inputecua);
		System.out.println("Ecuación:\n");
		while (matcher.find()) {
			System.out.printf("%-25s", matcher.group(0));
			resultincog1 = 0;
			resultincog2 = 0;
			resultnum1 = 0;
			resultnum2 = 0;
			ecuacion = matcher.group(0);
			expresion1 = ecuacion.substring(0, ecuacion.indexOf("="));
			expresion2 = ecuacion.substring(ecuacion.indexOf("=")+1);
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
			patternnum = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Digit}]+?))*?$", Pattern.MULTILINE);
			matcher2 = patternnum.matcher(expresion1);
			while (matcher2.find()) {
				num = Integer.parseInt(matcher2.group(3));
				if(matcher2.group(2).equalsIgnoreCase("+")) {
					resultnum1 = resultnum1 + num;
				}else if(matcher2.group(2).equalsIgnoreCase("-")) {
					resultnum1 = resultnum1 - num;
				}	
			}

			patternincog = Pattern.compile("^(([\\p{Punct}&&[-+]])((([\\p{Digit}]*?)([\\p{Lower}&&[x]]))|(([\\p{Lower}&&[x]])([\\p{Digit}]*?))))*?$", Pattern.MULTILINE);
			matcher2 = patternincog.matcher(expresion1);
			while (matcher2.find()) {
				if(matcher2.group(2).equalsIgnoreCase("+")) {
					if(matcher2.group(7) == null) {
						if (matcher2.group(5).isBlank()) {
							resultincog1++;
						}else {
							resultincog1 = resultincog1 + (Integer.parseInt(matcher2.group(5)));
						}
					}else {
						if (matcher2.group(9).isBlank()) {
							resultincog1++;
						}else {
							resultincog1 = resultincog1 + (Integer.parseInt(matcher2.group(9)));
						}
					}
				}else if(matcher2.group(2).equalsIgnoreCase("-")) {
					if(matcher2.group(7) == null) {
						if (matcher2.group(5).isBlank()) {
							resultincog1--;
						}else {
							resultincog1 = resultincog1 - (Integer.parseInt(matcher2.group(5)));
						}
					}else {
						if (matcher2.group(9).isBlank()) {
							resultincog1--;
						}else {
							resultincog1 = resultincog1 - (Integer.parseInt(matcher2.group(9)));
						}
					}
				}
			}
			
			patternnum = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Digit}]+?))*?$", Pattern.MULTILINE);
			matcher2 = patternnum.matcher(expresion2);
			while (matcher2.find()) {
				num = Integer.parseInt(matcher2.group(3));
				if(matcher2.group(2).equalsIgnoreCase("+")) {
					resultnum2 = resultnum2 + num;
				}else if(matcher2.group(2).equalsIgnoreCase("-")) {
					resultnum2 = resultnum2 - num;
				}    			
			}

			patternincog = Pattern.compile("^(([\\p{Punct}&&[-+]])((([\\p{Digit}]*?)([\\p{Lower}&&[x]]))|(([\\p{Lower}&&[x]])([\\p{Digit}]*?))))*?$", Pattern.MULTILINE);
			matcher2 = patternincog.matcher(expresion2);
			while (matcher2.find()) {
				if(matcher2.group(2).equalsIgnoreCase("+")) {
					if(matcher2.group(7) == null) {
						if (matcher2.group(5).isBlank()) {
							resultincog2++;
						}else {
							resultincog2 = resultincog2 + (Integer.parseInt(matcher2.group(5)));
						}
					}else {
						if (matcher2.group(9).isBlank()) {
							resultincog2++;
						}else {
							resultincog2 = resultincog2 + (Integer.parseInt(matcher2.group(9)));
						}
					}
				}else if(matcher2.group(2).equalsIgnoreCase("-")) {
					if(matcher2.group(7) == null) {
						if (matcher2.group(5).isBlank()) {
							resultincog2--;
						}else {
							resultincog2 = resultincog2 - (Integer.parseInt(matcher2.group(5)));
						}
					}else {
						if (matcher2.group(9).isBlank()) {
							resultincog2--;
						}else {
							resultincog2 = resultincog2 - (Integer.parseInt(matcher2.group(9)));
						}
					}
				}
			}
			resultnum = resultnum2 + (resultnum1*(-1));
			resultincog = resultincog1 + (resultincog2*(-1));            
			resultfin = resultnum/resultincog;
			System.out.println("Solución: x = " + resultfin);
		}
	}

	public static void main(String[] args) {

		new Exercise7v2().show();

	}

}
