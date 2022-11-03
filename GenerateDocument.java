import java.util.*;

public class GenerateDocument {

	public static void main(String[] args) {
		String characters = "aheaolabbhb";
		String  document = "hello";
		System.out.println(new GenerateDocument().generateDocument(characters, document));

	}

	  public boolean generateDocument(String characters, String document) {
			int n = document.length();
			int i = 0;
	    while (i < n) {
				int currentCharIndex = characters.indexOf(document.charAt(i));
				if (currentCharIndex == -1)
					return false;
				characters = characters.replaceFirst(Character.toString(document.charAt(i)), "");
				i++;
				System.out.println(characters + " " + i);
			}
			if (i == n)
				return true;
	    return false;
	  }

}
