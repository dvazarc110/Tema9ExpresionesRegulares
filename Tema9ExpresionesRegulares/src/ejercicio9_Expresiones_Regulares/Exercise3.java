package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

	public void show() {
		
		Pattern pattern = Pattern.compile("import\\s+([^;]+)");
		Matcher matcher = pattern.matcher("""
				package ejercicios9ExpresionesRegulares;
				import java.util.regex.Pattern;
				import java.util.regex.Matcher;
				public class Ejercicio1 {
				public void exercise1() {
				Pattern pattern = Pattern.compile("int");
				""");
		while (matcher.find()) {
			System.out.println(matcher.group(1));
		}
		
	}
	
	public static void main(String[] args) {

		new Exercise3().show();
		
	}

}
