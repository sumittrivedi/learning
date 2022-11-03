import java.util.*;

public class InterweavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public static boolean interweavingStrings(String one, String two, String three) {
		int n1 = one.length();
		int n2 = two.length();
		int n3 = three.length();
		if (n3 == 0) {
			if ( n1 == 0 && n2 == 0)
				return true;
			else
				return false;
		}
			
		if (n1 != 0 || n2 != 0) {
			char currentChar = three.charAt(0);
			if (n1 != 0 && n2 != 0) {
				int i = 0;
				int j = 0;
				if (one.charAt(0) == currentChar || two.charAt(0) == currentChar) {
					if (one.charAt(0) == currentChar && two.charAt(0) == currentChar) {
						return interweavingStrings(one.substring(1, n1), two, three.substring(1, n3)) || interweavingStrings(one, two.substring(1, n2), three.substring(1, n3));
					} else {
						if (one.charAt(0) == currentChar) {
							return interweavingStrings(one.substring(1, n1), two, three.substring(1, n3));
						} else {
							return interweavingStrings(one, two.substring(1, n2), three.substring(1, n3));
						}
					}
				} else {
					return false;
				}
			} else {
				if (n1 != 0) {
					if (one.charAt(0) != currentChar)
						return false;
					else {
						return interweavingStrings(one.substring(1, n1), two, three.substring(1, n3));
					}
				} else {
					if (two.charAt(0) != currentChar)
						return false;
					else {
						return interweavingStrings(one, two.substring(1, n2), three.substring(1, n3));
					}
				}
			}

		} else {
			return false;
		}
	}
}
