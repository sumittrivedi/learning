import java.util.*;

//O(n) time and O(n) Space
class SingleCycleCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean hasSingleCycle(int[] a) {
		int n = a.length;
		HashSet<Integer> set = new HashSet<>();
		int currentIndex = 0;
		int nextIndex = -1;
		int startIndex = currentIndex;
		boolean flag = true;
		while (nextIndex != startIndex) {
			nextIndex = (currentIndex + a[currentIndex]) % n;
			if (nextIndex < 0)
				nextIndex = n + nextIndex;
			if (set.contains(nextIndex)) {
				flag = false;
				break;
			} else {
				set.add(nextIndex);
			}
			currentIndex = nextIndex;
		}
		if (set.size() != n)
			flag = false;
		return flag;
	}
}
