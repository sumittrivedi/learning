import java.util.*;

public class Permutation {
	
	public static List<List<Integer>> getPermutations(List<Integer> array) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> onePermutation = new ArrayList<>();
		createPermutation(array, output, onePermutation);
		return output;
	}
	
	private static void createPermutation(List<Integer> array, List<List<Integer>> permutations, List<Integer> onePermutation) {
		int size = array.size();
		if (size == 1) {
			onePermutation.add(array.get(0));
			permutations.add(onePermutation);
			return;
		}
		for (int i = 0; i < size; i++) {
			List<Integer> newArray = new ArrayList<>(array);
			newArray.remove(i);
			List<Integer> newPermutation = new ArrayList<>(onePermutation);
			newPermutation.add(array.get(i));
			createPermutation(newArray, permutations, newPermutation);
		}
	}
	
	public ArrayList<String> validIPAddresses(String string) {
	    int length = string.length();
			List<String> validIps = new ArrayList<>();
			if(length < 4 || length > 12)
				return (ArrayList<String>) validIps;
			
	    return (ArrayList<String>) validIps;
	  }
	
	 public int firstNonRepeatingCharacter(String string) {
		 Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < string.length(); i++) {
				if (map.get(String.valueOf(string.charAt(i))) != null ) 
					map.put(String.valueOf(string.charAt(i)), map.get(String.valueOf(string.charAt(i))) + 1);
				else
					map.put(String.valueOf(string.charAt(i)), 0);
			}
			int firstNonRepeatingCharindex = -1;
			int i = 0;
			while (i < string.length()) {
				if (map.get(String.valueOf(string.charAt(i))) == 1) {
					firstNonRepeatingCharindex = i; break;
				}
				i++;	
			}
	    return firstNonRepeatingCharindex;
	  }
	 
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
//		array.add(21);
//		array.add(22);
//		array.add(99);
//		array.add(73);
//		array.add(13);
//				Arrays.asList(1,2,3);
		//System.out.println(new Permutation().sortStack(array));
		Permutation.getPermutations(array).forEach(System.out :: println);
//		array.forEach(System.out::println);

	}

}
