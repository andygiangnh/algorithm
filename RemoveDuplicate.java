import java.util.Set;
import java.util.HashSet;
public class RemoveDuplicate {
	
	public static void main(String[] args) {
		String str = "abfabddacbf";
		String newStr = "";
		Set<Character> allChars = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (allChars.contains(c)) {
				// remove at char at i
				str = str.substring(0,i) + str.substring(i+1, str.length());
				i--;
			} else {
				allChars.add(c);
				
			}
		}

		System.out.println(str);
	}
}