package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {

	public void show() {
		
		Pattern pattern = Pattern.compile("package\\s+([^;]+)");
		Matcher matcher = pattern.matcher("""
				package ejercicios9ExpresionesRegulares;
				import java.util.regex.Pattern;
				import java.util.regex.Matcher;
				public class Ejercicio1 {
				public void exercise1() {
				Pattern pattern = Pattern.compile("int");
				""");
		if (matcher.find()) {
			System.out.println(matcher.group(1));
		}
		
	}
	
	public static void main(String[] args) {

		new Exercise2().show();
		
	}

}
