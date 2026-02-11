package ejercicio9_Expresiones_Regulares;

public class PuebasExercise6 {

	public void show() {
		
		String ecuacion = "4+x-3-x+1+x=x+x+x-1-1";
		String expresion1 = ecuacion.substring(0, ecuacion.indexOf("="));
		String expresion2 = ecuacion.substring(ecuacion.indexOf("=")+1);
		
		System.out.println(expresion1);
		System.out.println(expresion2);
		
	}
	
	public static void main(String[] args) {

		new PuebasExercise6().show();
		
	}

}
