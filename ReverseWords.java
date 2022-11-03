import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

	public static void main(String[] args) {
		String string = "I am a man";
		new ReverseWords().reverseWordsInString(string);

	}
	
	 public String reverseWordsInString(String string) {
		    List<String> words = new ArrayList<>();
				int n = string.length();
				int startOfWord = 0;
				while (startOfWord < n ) {
					int endOfWord = startOfWord;
					if (string.charAt(startOfWord) == ' ') {
						System.out.println(startOfWord +" "+endOfWord);
						while (endOfWord < n && string.charAt(endOfWord) == ' ')
							endOfWord++;
						
						
					}
					else {
						while (endOfWord < n && string.charAt(endOfWord) != ' ')
							endOfWord++;
					}
					System.out.println("substring (" + string.substring(startOfWord, endOfWord) + ")");
					words.add(string.substring(startOfWord, endOfWord));
					startOfWord = endOfWord ;
				}
				
				Collections.reverse(words);
		    return String.join("", words);
		  }
}
