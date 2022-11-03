import java.util.*;

class StairCase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


  public int staircaseTraversal(int height, int maxSteps) {
		Map<Integer, Integer> map = new HashMap<>();
		if (height == 1)
			return 1;
		map.put(0, 1);
		map.put(1, 1);
		int temp = 2;
		for (int i = 2; i <= maxSteps; i++) {
			map.put(i, temp);
			temp += map.get(i); 
		}
    return helperMethod(map, maxSteps, height);
  }
	
	private int helperMethod(Map<Integer, Integer> map, int maxSteps, int height) {
		if (map.get(height) != null)
			return map.get(height);
		int temp = 0;
		for ( int i = height - 1; i >= height - maxSteps; i--) {
			temp += helperMethod(map, maxSteps, height - 1);
		}
		return temp;
	}
}


