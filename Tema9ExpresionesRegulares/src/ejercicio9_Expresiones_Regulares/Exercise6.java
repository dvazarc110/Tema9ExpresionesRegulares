package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise6 {

	public void show() {
		
		String text = "Esto es un texto escrito en español";
        Pattern pattern;
        Matcher matcher;
		
        System.out.println("Característicasde nuestras ecuaciones:\n- Solo una incógnita: x");
        
		pattern = Pattern.compile("^Lín.*", Pattern.MULTILINE);
		matcher = pattern.matcher("""
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
		System.out.println("Ecuaciones: Soluciones: ");
        while (matcher.find()) {
            System.out.println(matcher.start());
        }
	}
	
	public static void main(String[] args) {

		new Exercise6().show();
		
	}

}
