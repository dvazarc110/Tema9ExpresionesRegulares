package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise5 {

	public void show() {
		
		Pattern pattern = Pattern.compile("while\\s+\\(([^{]+)\\)");
		Matcher matcher = pattern.matcher("""
				package ejercicios9ExpresionesRegulares;
				import java.util.regex.Pattern;
				import java.util.regex.Matcher;
				// comentario;
				// comentario 2;
				public class Ejercicio1 {
				public void exercise1() {
				Pattern pattern = Pattern.compile("int");
				while (matcher.find()) {
					System.out.println(matcher.group(1));
				}
				while (test > 8){
					syso(2);
				""");
		while (matcher.find()) {
			System.out.println(matcher.group(1));
		}
		
	}
	
	public static void main(String[] args) {

		new Exercise5().show();
		
	}
	
}
