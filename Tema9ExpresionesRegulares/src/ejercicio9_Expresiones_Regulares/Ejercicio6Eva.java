package ejercicio9_Expresiones_Regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio6Eva {
	
	public void solveFirstDegreeEquations() {
		
		String text = "Ecuaciones de primer grado con una incógnita. Veamos algunos ejemplos: \n"
				+ "\n"
				+ "Ejercicio1: -x-=3+13\n"
				+ "\n"
				+ "Ejercicio2: 8+70=x\n"
				+ "\n"
				+ "Ejercicio3: 2-x=x-8\n"
				+ "\n"
				+ "Ejercicio4: x-1+x+3=2+x+8-x\n"
				+ "\n"
				+ "Ejercicio5: 4+x-3-x+1+x=x+x+x-1-1"
				+ "\n"
				+ "No vale: ++x-3=x+6"
				+ "\n"
				+ "No vale: x++5=8+x"
				+ "\n"
				+ "No vale: x=--x"
				+ "\n"
				+ "No vale: 3-1+x=-4+6--x";
		solve(text);
		
	}
	
	public void solve(String text) {		
		Pattern pattern = Pattern.compile("([0-9x+-]+)=([0-9x+-]+)");
		String left,right;
		Matcher matcher = pattern.matcher(text);
		int xNum=0,num=0;
		while(matcher.find()) {
			left=matcher.group(1);
			right=matcher.group(2);
			//Tiene que haber alguna x y no puede haber dos operadores seguidos
			if((left.contains("x") || right.contains("x"))
				&& check(left) && check(right)) {
				//Se pasan las x a la izquierda
				xNum = xSolve(left)-xSolve(right);
				//Se pasan los números a la derecha
				num = numSolve(right)-numSolve(left);
				System.out.printf("%-21s   Solución: %d\n",matcher.group(0),num/xNum);
			}			
		}		
	}
	
	public boolean check (String text) {
		boolean check;
		if(!text.contains("--") && !text.contains("++") &&
		   !text.contains("-+") && !text.contains("+-")) {
			check=true;
		}else {
			check=false;
		}
		return check;
	}
	
	public int xSolve(String xText) {		
		Pattern pattern = Pattern.compile("([+-]?)x");
		Matcher matcher = pattern.matcher(xText);
		int sum=0;
		String operator;
		while(matcher.find()) {
			operator = matcher.group(1);
			if(operator.equals("-")) {
				sum-=1;
			}else {
				sum+=1;
			}
		}
		return sum;
	}
	
	public int numSolve(String xText) {		
		Pattern pattern = Pattern.compile("([+-]?)([0-9]+)");
		Matcher matcher = pattern.matcher(xText);
		int sum=0,num;
		String operator;
		while(matcher.find()) {			
			operator = matcher.group(1);
			num = Integer.parseInt(matcher.group(2));
			if(operator.equals("-")) {
				sum-=num;
			}else {
				sum+=num;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		new Ejercicio6Eva().solveFirstDegreeEquations();

	}

}
