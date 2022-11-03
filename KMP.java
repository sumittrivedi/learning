
public class KMP {

	public static void main(String[] args) {
		System.out.println(knuthMorrisPrattAlgorithm("aefoaefcdaefcdaed", "aefcdaed"));
//		System.out.println(kmp("testwherethefullstringmatches", "aefcdaed"));

	}

	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
		int m = string.length();
		int n = substring.length();
		int pi[] = createPiTable(substring);
		int i = 0;
		int j = 0;
		while (i < m) {
			if (j < n && string.charAt(i) == substring.charAt(j)) {
				i++;
				j++;
			}
			if (j == n)
				return true;
			else {
				if (string.charAt(i) != substring.charAt(j)) {
					if (j != 0)
						j = pi[j - 1];
					else
						i++;
				}
			}
		}
		return false;
	}

private static int[] createPiTable(String substring) {
	int n = substring.length();
	int[] pi = new int[n];
	for (int i = 1; i < n; i++) {
	if ( pi[i - 1] > 0 && substring.charAt(pi[i - 1]) == substring.charAt(i)) {
			pi[i] = 1 + pi[i - 1];
		}
		else if (substring.charAt(i) == substring.charAt(0)) 
			pi[i] = 1;
	}
	for (int x : pi)
	System.out.print(x);
	return pi;
}
	
	public static boolean kmp(String string, String substring) {
		int[] pi = piTable(substring);
		int m = substring.length();
		int n = string.length();
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (j < m && substring.charAt(j) == string.charAt(i))
				j++;
			else {
				if (j != 0) {
					if (j == m)
						return true;
					else
						i--;
					j = pi[j - 1];
				}
			}
		}
		return false;
	}

	private static int[] piTable(String pattern) {
		int length = pattern.length();
		int[] pi = new int[length];
		for (int i = 1; i < length; i++) {
			if (pi[i - 1] > 0 && pattern.charAt(pi[i - 1]) == pattern.charAt(i))
				pi[i] = pi[i - 1] + 1;
			else if (pattern.charAt(i) == pattern.charAt(0))
				pi[i] = 1;
		}
		for (int x : pi)
			System.out.print(x);
		return pi;
	}

	
	

}
