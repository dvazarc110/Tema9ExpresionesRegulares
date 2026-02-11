package ejercicio9_Metodo_Matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReluctantQuantifiers {
	
	public void show() {
		
		Pattern patternGreedy = Pattern.compile("a+");
		Pattern patternReluctant = Pattern.compile("(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?=(([\\p{Punct}&&[-+]]??)([\\p{Lower}&&[x]]|[\\p{Digit}]+?)){1}?(([\\p{Punct}&&[-+]])([\\p{Lower}&&[x]]|[\\p{Digit}]+?))*?");
		Matcher matcherGreedy = patternGreedy.matcher("aaaa");
		Matcher matcherReluctant = patternReluctant.matcher("4+x-3-x+1+x=x+x+x-1-1");

		while (matcherGreedy.find()) {
			System.out.printf("Greedy: coincidencia desde %d hasta %d\n", matcherGreedy.start(),
					matcherGreedy.end() - 1);
		}
		while (matcherReluctant.find()) {
			System.out.printf("Reluctant: coincidencia desde %d hasta %d\n", matcherReluctant.start(),
					matcherReluctant.end() - 1);
		}
		
	}

	public static void main(String[] args) {

		new ReluctantQuantifiers().show();

	}

}
