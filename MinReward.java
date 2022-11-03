import java.util.*;

public class MinReward {
	
	public static int minRewards(int[] scores) {
		int noOfScores = scores.length;
		int[] rewards = new int[noOfScores];
		Map<Integer, Integer> treeMap = new TreeMap<>();
		for (int i = 0; i < noOfScores; i++)
			treeMap.put(scores[i], i);

		treeMap.forEach((key, value) -> {
			int index = value;
			if (index > 0 && index < noOfScores - 1)
				rewards[index] = 1 + Math.max(rewards[index - 1], rewards[index + 1]);
			else {
				if (index == 0) {
					rewards[index] = noOfScores > 1 ? 1 + rewards[index + 1] : 1;
				} else
					rewards[index] = 1 + rewards[index - 1];
			}
		});
		return Arrays.stream(rewards).sum();
	}

	public static void main(String[] args) {
		int[] array = {8, 4, 2, 1, 3, 6, 7, 9, 5};
		System.out.println(MinReward.minRewards(array));
	}

}
