
public class Palindrom {
	public static boolean check(String text) {
		String reversedText = "";

		text = text.toLowerCase();
		text = text.replaceAll("[ ,.-?/!]", "");

		for(int i = text.length() - 1; i >= 0; i--) {
			reversedText += text.charAt(i);
		}

		return text.equals(reversedText); 
	}
}
