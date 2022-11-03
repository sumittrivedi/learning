import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagram.groupAnagrams(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")).stream()
				.forEach(System.out::println);

	}

	public static List<List<String>> groupAnagrams(List<String> words) {
		Map<String, List<String>> map = new HashMap<>();
		for (String word : words) {
			char[] array = word.toCharArray();
			Arrays.sort(array);
			String sortedWord = new String(array);
			if (map.containsKey(sortedWord))
				map.get(sortedWord).add(word);
			else
				map.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
		}
		return new ArrayList<>(map.values());

	}

//		Map<String, List<Integer>> hashMap = new HashMap<>();
//		List<String> sortedWords = words.stream().
//				map(x -> {
//			char[] array = x.toCharArray();
//			Arrays.sort(array);
//			List<Integer> list = new ArrayList<>();
//			list.add(2);
//			hashMap.put(x, list);
//			return new String(array);
//
//		})
//				.collect(Collectors.toMap(x, new ArrayList<Integer>()));
//		sortedWords.forEach(System.out::println);
//		System.out.println(hashMap.get("oy"));
//		return new ArrayList<>();

}
