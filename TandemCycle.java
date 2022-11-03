import java.util.*;

public class TandemCycle {
	
	  public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
	    Arrays.sort(redShirtSpeeds);
			Arrays.sort(blueShirtSpeeds);
			int n = redShirtSpeeds.length;
			int j = fastest == true ? n - 1 : 0;
			int maxSpeed = 0;
			for (int i = 0; i < n; i++ ) {
				maxSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[j]);
				System.out.println("i = " + i+ "j = " + j +" "+maxSpeed +" "+ redShirtSpeeds[i] +" "+ blueShirtSpeeds[j]);
				j = fastest == true ? j-1 : j+1;
			}	
	    return maxSpeed;
	  }
	
	  public static void main(String args[]) {
		 int blueShirtSpeeds[] = {3, 6, 7, 2, 1};
		 boolean fastest = true;
		 int redShirtSpeed[] = {5, 5, 3, 9, 2};
		System.out.println(tandemBicycle(redShirtSpeed, blueShirtSpeeds, fastest ));
	}

}
