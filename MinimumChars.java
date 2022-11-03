import java.util.*;

class MinimumChars {
	
	public static void main(String args[]) {
		String[] words = {"th", "that", "dd", "deed", "tem!", "a"};
		char[] array = new MinimumChars().minimumCharactersForWords(words);
		for (char x : array) 
			System.out.print(x + " "
					+ "");
	}

	public char[] minimumCharactersForWords(String[] words) {
		List<Character> list = new ArrayList<Character>();
		Stack<Character> stack = new Stack<Character>();
		for (String word : words) {
			char[] letters = word.toCharArray();
			for (char letter : letters) {
				if (list.contains(letter)) {
					list.remove(new Character(letter));
					stack.push(Character.valueOf(letter));
				} else {
					stack.add(letter);
				}
			}
			while (!stack.empty()) 
				list.add(stack.pop());
		}
		char[] minimunCharacters = new char[list.size()];
		for (int i = 0; i < list.size(); i++) {
			minimunCharacters[i] = list.get(i).charValue();
		}
		return minimunCharacters;
	}
}
