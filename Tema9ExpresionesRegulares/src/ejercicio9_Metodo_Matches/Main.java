package ejercicio9_Metodo_Matches;

public class Main {

	public void show() {
		
		System.out.println("1º que la cadena sea exactamente “lunes”.");
		System.out.println("lune :" + "lune".matches("lunes"));
		System.out.println("lunes :" + "lunes".matches("lunes"));
		System.out.println("2º que la cadena sea de tres letras, mayúsculas o minúsculas.");
		System.out.println("aH5 :" + "aH5".matches("[\\p{Alpha}ñÑ]{3}"));
		System.out.println("ñHj :" + "ñHj".matches("[\\p{Alpha}ñÑ]{3}"));
		System.out.println("3º que la cadena contenga 5 o más caracteres que no sean la ñ, la z ni la x.");
		System.out.println("aHñZx:" + "aHñZx".matches("[\\p{Alpha}&&[^xzXZ]]{5,}"));
		System.out.println("aHjTM" + "aHjTM".matches("[\\p{Alpha}&&[^xzXZ]]{5,}"));
		System.out.println("4º que la cadena no empiece con un número.");
		System.out.println("9casa" + "9casa".matches("\\D.+"));
		System.out.println("gcasa" + "gcasa".matches("\\D.+"));
		System.out.println("5º que la cadena tenga varios caracteres excepto la b.");
		System.out.println("bala :" + "bala".matches("[a-z&&[^b]]+"));
		System.out.println("pala :" + "pala".matches("[a-z&&[^b]]+"));
		System.out.println("6º que la cadena sea un número de teléfono.");
		System.out.println("675y567u9 :" + "675y567u9".matches("\\d{9}"));
		System.out.println("445326789 :" + "445326789".matches("\\d{9}"));
		System.out.println("7º que la cadena sea un DNI.");
		System.out.println("123456789 :" + "123456789".matches("\\d{8}\\p{Upper}"));
		System.out.println("12345T789 :" + "12345T789".matches("\\d{8}\\p{Upper}"));
		System.out.println("55647324D :" + "55647324D".matches("\\d{8}\\p{Upper}"));
		System.out.println("8º que la cadena sea un nombre, es decir, que no tenga espacios, que no sea una cadena vacía y que empiece por mayúsculas.");
		System.out.println("a tre5 :" + "a tre5".matches("\\p{Upper}[\\p{Lower}ñ]+"));
		System.out.println("Daniel :" + "Daniel".matches("\\p{Upper}[\\p{Lower}ñ]+"));
		System.out.println("9º que la cadena empiece con vocal y luego tenga varias consonantes o ninguna. ");
		System.out.println("esquia :" + "esquia".matches("\\b[a-z&&[aeiou]][a-z&&[^aeiou]]*"));
		System.out.println("echrsl :" + "echrsl".matches("\\b[a-z&&[aeiou]][a-z&&[^aeiou]]*"));
		System.out.println("10º que la cadena sea un número positivo más pequeño que 300.");
		System.out.println("300 :" + "300".matches("([12]?[0-9]{0,2})"));
		System.out.println("299 :" + "299".matches("([12]?[0-9]{0,2})"));
		System.out.println("- :" + "-".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("4 :" + "4".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("x :" + "x".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("y :" + "y".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-x :" + "-x".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-4 :" + "-4".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-- :" + "--".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-x :" + "-x".matches("[\\p{Punct}&&[-]]?[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-4 :" + "-4".matches("[\\p{Punct}&&[-]]?[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-x+5 :" + "-x+5".matches("[\\p{Punct}&&[-]]?[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-4+x :" + "-4+x".matches("[\\p{Punct}&&[-]]?[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("x- :" + "x-".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("4- :" + "4-".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-- :" + "--".matches("[\\p{Punct}&&[-]]?|[\\p{Alnum}&&[x\\d]]?"));
		System.out.println("-- :" + "--".matches("[\\p{Graph}&&[x\\d-]]?-"));
		System.out.println("4- :" + "4-".matches("[\\p{Graph}&&[x\\d-]]?-"));
		System.out.println("x- :" + "x-".matches("[\\p{Graph}&&[x\\d-]]?-"));
		System.out.println("y- :" + "y-".matches("[\\p{Graph}&&[x\\d-]]?-"));
		System.out.println("-- :" + "--".matches("-?[\\p{Graph}&&[x\\d]]?[\\p{Graph}&&[x\\d-]]?"));
		System.out.println("4- :" + "4-".matches("-?[\\p{Graph}&&[x\\d]]?[\\p{Graph}&&[x\\d-]]?"));
		System.out.println("x- :" + "x-".matches("-?[\\p{Graph}&&[x\\d]]?[\\p{Graph}&&[x\\d-]]?"));
		System.out.println("y- :" + "y-".matches("-?[\\p{Graph}&&[x\\d]]?[\\p{Graph}&&[x\\d-]]?"));
		System.out.println("-4 :" + "-4".matches("-?[\\p{Graph}&&[x\\d]]?[\\p{Graph}&&[x\\d-]]?"));
		System.out.println("-x :" + "-x".matches("-?[\\p{Graph}&&[x\\d]]?[\\p{Graph}&&[x\\d-]]?"));
		System.out.println("-y :" + "-y".matches("-?[\\p{Graph}&&[x\\d]]?[\\p{Graph}&&[x\\d-]]?"));
		System.out.println("-x+5=10-3 :" + "-x+5=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-4+x=10-3 :" + "-4+x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("--x+5=10-3 :" + "--x+5=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-4++x=10-3 :" + "-4++x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-x4+5=10-3 :" + "-x4+5=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-4x+x=10-3 :" + "-4x+x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-x+54=10-3 :" + "-x+54=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-4+xx=10-3 :" + "-4+xx=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-x+5==10-3 :" + "-x+5==10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-4+x=10-3 :" + "-4+x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1,}"));
		System.out.println("-4+x=10-3 :" + "-4+x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]{1})(x)|([\\p{Punct}&&[-+]])(\\d+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Alnum}&&[x\\d]])){1}(([\\p{Punct}&&[-+]]{1})(x)|([\\p{Punct}&&[-+]])(\\d+)){1,}"));
		System.out.println("");
		System.out.println("-x+5=10-3 :" + "-x+5=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-4+x=10-3 :" + "-4+x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("--x+5=10-3 :" + "--x+5=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-4++x=10-3 :" + "-4++x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-x4+5=10-3 :" + "-x4+5=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-4x+x=10-3 :" + "-4x+x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-x+54=10-3 :" + "-x+54=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-4+xx=10-3 :" + "-4+xx=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-x+5==10-3 :" + "-x+5==10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1,}"));
		System.out.println("-4+x=10-3 :" + "-4+x=10-3".matches("(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+))*=(([\\p{Punct}&&[-+]]?)([\\p{Lower}&&[x]]|[\\p{Digit}]+)){1}(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+))*"));
	}
	
	public static void main(String[] args) {

		new Main().show();
		
	}

}
