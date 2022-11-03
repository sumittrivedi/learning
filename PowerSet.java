import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(1, 2, 3);
		PowerSet.powerset(array).forEach(System.out::println);
	}

	public static List<List<Integer>> powerset(List<Integer> array) {
		List<List<Integer>> powerSets = new ArrayList<>();
		int n = array.size();
		for (int i = 0; i < 1<<n; i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if((i & (1<<j)) > 0)
					subset.add(array.get(j));
			}
			powerSets.add(subset);
		}
		return powerSets;
	}

}
