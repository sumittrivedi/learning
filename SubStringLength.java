/*
 * Given a string s and an integer k, return the length of the longest substring
 * of s such that the frequency of any character in this substring is greater
 * than or equal to k.
 * 
 * Example 1: Input: s = "aaabb", k = 3 
 * Output: 3 Explanation: 
 * The longest substring is "aaa", as 'a' is repeated 3 times. 
 
 * Example 2: 
 * Input: s ="ababbc", k = 2 
 * Output: 5 Explanation: The longest sub
 
 * input = abcaghah, k = 3
 * output = 7
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcaghah";
		System.out.println(SubStringLength.longestSubStrLength(str, 3));

	}
	
	private static int longestSubStrLength(String str, int k) {
		Map<Character, List<Integer>> map = new HashMap<>(); // index 0 = min index, index 1 = max index, index 2 = freq
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++ ) {
			if(map.containsKey(array[i])) {
				List<Integer> value = map.get(array[i]);
				int minIndex = Math.min(i, value.get(0));
				int maxIndex = Math.max(i, value.get(1));
				int frequency = 1 + value.get(2);
				map.put(array[i], new ArrayList<>(Arrays.asList(minIndex, maxIndex, frequency)));
			}
			else {
				map.put(array[i], new ArrayList<>(Arrays.asList(i, i, 1)));
			}
		}
		
		int startIndex = Integer.MAX_VALUE;
		int lastIndex = Integer.MIN_VALUE;
		
		for (Character c : map.keySet()) {
			if(map.get(c).get(2) >= k) {
				startIndex = Math.min(startIndex, map.get(c).get(0));
				lastIndex = Math.max(lastIndex, map.get(c).get(1));
			}
		}
		return lastIndex - startIndex + 1;
	}

}
