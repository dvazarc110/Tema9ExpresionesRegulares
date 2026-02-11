package ejercicio9_Metodo_Matches;

public class GreedyQuantifiers {
	
	public void show() {
		
		/*
		 * El símbolo ? sirve para indicar que la expresión que le
		 * antecede puede aparecer una o ninguna vez
		 */
		System.out.println("acab".matches("[a?bc{0,2}]{1,3}"));//true
		System.out.println("".matches("a?"));//true
		System.out.println("ab".matches("a?b"));//false
		System.out.println("");
		System.out.println("-xx :" + "-xx".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}"));
		System.out.println("-44 :" + "-44".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+))"));
		System.out.println("-444++4+:" + "-444++4+".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-4+x+8=10-3-5+3 :" + "-4+x+8=10-3-5+3".matches("(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?=(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?"));
		System.out.println("-xx=10-3 :" + "-xx=10-3".matches("(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?=(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?"));
		System.out.println("-4+x=10-3 :" + "-4+x=10-3".matches("(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?=(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?"));
		System.out.println("");

		/* 
		 * El símbolo * indica que la expresión puede repetirse 
		 * ninguna o varias veces
		 */
		System.out.println("a".matches("a*"));//true
		System.out.println("".matches("a*"));//true
		System.out.println("aaaa".matches("a*"));//true
		System.out.println("b".matches("a*"));//false

		/* 
		 * El símbolo + indica que la expresión puede repetirse
		 * una o varias veces
		 */
		System.out.println("a".matches("a+"));//true
		System.out.println("aaaa".matches("a+"));//true
		System.out.println("".matches("a+"));//false
		System.out.println("b".matches("a+"));//false

		//Un número entre llaves indica las veces que se repite la expresión
		System.out.println("aaa".matches("a{3}"));//true
		System.out.println("aaa".matches("a{4}"));//false

		/*
		 * Un número entre llaves con una coma indica el mínimo
		 * de veces que se repite la expresión
		 */
		System.out.println("aaa".matches("a{3,}"));//true
		System.out.println("aaaaa".matches("a{3,}"));//true
		System.out.println("aa".matches("a{3,}"));//false

		/*
		 * Como el anterior pero aparece un segundo número que
		 * indica el máximo de veces que se repite la expresión
		 */
		System.out.println("aaa".matches("a{3,6}"));//true
		System.out.println("aaaaaa".matches("a{3,6}"));//true
		System.out.println("aa".matches("a{3,6}"));//false
		System.out.println("aaaaaaa".matches("a{3,6}"));//false
		
	}

	public static void main(String[] args) {

		new GreedyQuantifiers().show();

	}

}
