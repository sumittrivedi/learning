
public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println(LongestSubstring.longestSubstringWithoutDuplication("abccdeaabbcddef"));
	}

	public static String longestSubstringWithoutDuplication(String str) {
		String longestSubtring = "";
		String substring = "";
		int n = str.length();
		char[] charArray = str.toCharArray();
		for (int i = 0; i < n; i++) {
			if (substring.contains(String.valueOf(charArray[i]))) {
				substring = substring.substring(substring.indexOf(charArray[i]) + 1);
			}
			substring += String.valueOf(charArray[i]);
			if (longestSubtring.length() < substring.length()) {
				longestSubtring = substring;
			}
			System.out.println(longestSubtring + " ==> " + substring);
		}
		return longestSubtring;
	}
}
