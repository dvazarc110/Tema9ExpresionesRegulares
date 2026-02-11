package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1 {

	public void show() {
		
		Pattern pattern = Pattern.compile("\\bint\\b");
		Matcher matcher = pattern.matcher("""
				int x = 0;
				int y = 0;
				byte x2 = 0;
				byte y2 = 0;
				double x3 = 0;
				double y3 = 0;
				float x4 = 0;
				float y4 = 0;
				""");
		String resultado = matcher.replaceAll("byte");
		pattern = Pattern.compile("\\bdouble\\b");
		matcher = pattern.matcher(resultado);
		resultado = matcher.replaceAll("float");
		System.out.println(resultado);
		
	}
	
	public static void main(String[] args) {

		new Exercise1().show();
		
	}

}
