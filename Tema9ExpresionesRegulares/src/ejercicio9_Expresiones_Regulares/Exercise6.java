package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise6 {

	public void show() {
		
		String text = "Esto es un texto escrito en español";
        Pattern pattern;
        Matcher matcher;
		
        System.out.println("Característicasde nuestras ecuaciones:\n- Solo una incógnita: x");
        
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
		System.out.println("Ecuaciones: Soluciones: ");
        while (matcher.find()) {
        	System.out.printf("\nEcuacion: %s\n", matcher.group(0));
			System.out.printf("-----Primera expresion---- \n%s%s\n", matcher.group(1), (matcher.group(4)=="null" ? "" : matcher.group(4)));
			System.out.printf("Primer término: %s\n", matcher.group(3));
			if(matcher.group(4)!="null") {
				System.out.printf("Segundo término: %s\n", matcher.group(6));
			}
			System.out.printf("-----Segunda expresion---- \n%s%s\n", matcher.group(7), matcher.group(10));
			System.out.printf("Primer término: %s\n", matcher.group(9));
			System.out.printf("Segundo término: %s\n", matcher.group(12));
			
        }
	}
	
	public static void main(String[] args) {

		new Exercise6().show();
		
	}

}
