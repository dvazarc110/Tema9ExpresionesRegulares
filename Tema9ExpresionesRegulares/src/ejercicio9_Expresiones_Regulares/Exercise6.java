package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise6 {

	public void show() {
		
        Pattern pattern, patternnum, patternincog;
        Matcher matcher, matcher2;
        String ecuacion, expresion1, expresion2;
        int num, resultnum, resultincog, resultfin;
        int countincog1 = 0;
        int countincog2 = 0;
		int resultincog1 = 0;
		int resultincog2 = 0;
        int resultnum1 = 0;
        int resultnum2 = 0;
                
        pattern = Pattern.compile("^(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?=(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?$", Pattern.MULTILINE);
		matcher = pattern.matcher(""" 
									x=3+13
									8+70=x
									2-x=x-8
									x-1+x+3=2+x+8-x
									4+x-3-x+1+x=x+x+x-1-1
									++x-3=x+6
									x++5=8+x
									x=--x
									3-1+x=-4+6--x
									
									""");
		
		System.out.println("Ecuaciones:\n");
		
        while (matcher.find()) {
        	
        	System.out.printf("%-25s", matcher.group(0));
        	countincog1 = 0;
            countincog2 = 0;
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
            
            patternincog = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]))*?$", Pattern.MULTILINE);
            matcher2 = patternincog.matcher(expresion1);
            while (matcher2.find()) {
    			if(matcher2.group(2).equalsIgnoreCase("+")) {
    				if (countincog1 == 0) {
    					resultincog1 = 1;
    					countincog1++;
    				}else {
    					resultincog1 = resultincog1 + 1;
    				}
    			}else if(matcher2.group(2).equalsIgnoreCase("-")) {
    				if (countincog1 == 0) {
    					resultincog1 = -1;
    					countincog1++;
    				}else {
    					resultincog1 = resultincog1 - 1;
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
            
            patternincog = Pattern.compile("^(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]))*?$", Pattern.MULTILINE);
            matcher2 = patternincog.matcher(expresion2);
            while (matcher2.find()) {
            	if(matcher2.group(2).equalsIgnoreCase("+")) {
    				if (countincog2 == 0) {
    					resultincog2 = 1;
    					countincog2++;
    				}else {
    					resultincog2 = resultincog2 + 1;
    				}
    			}else if(matcher2.group(2).equalsIgnoreCase("-")) {
    				if (countincog2 == 0) {
    					resultincog2 = -1;
    					countincog2++;
    				}else {
    					resultincog2 = resultincog2 - 1;
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
		new Exercise6().show();
	}

}