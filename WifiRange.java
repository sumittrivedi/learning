public class WifiRange {

	public static void main(String[] args) {
		System.out.println(WifiRange.wifiRange(5, 1, "10010"));
		System.out.println(WifiRange.wifiRange(3, 0, "010"));
	}

	private static boolean wifiRange(int n, int range, String s) {
		int[] nearestLeftRange = new int[n];
		int[] nearestRightRange = new int[n];
		nearestLeftRange[0] = s.charAt(0) == '1' ? 0 : -1 - range;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == '1')
				nearestLeftRange[i] = i;
			else
				nearestLeftRange[i] = nearestLeftRange[i - 1];
		}
		nearestRightRange[n - 1] = s.charAt(n - 1) == '1' ? n - 1 : n + range;
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '1')
				nearestRightRange[i] = i;
			else
				nearestRightRange[i] = nearestRightRange[i + 1];

		}
		for (int i = 0; i < n; i++) {
			if ((nearestRightRange[i] - i <= range) || (i - nearestLeftRange[i] <= range))
				continue;

			else
				return false;
		}

		return true;
	}

}
