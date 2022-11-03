import java.util.*;
import java.util.Map.Entry;

public class TaskAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
	   	Map<Integer, Integer> map = new HashMap<>();
			int size = tasks.size();
			for (int i = 0; i < size; i++) {
				map.put(i, tasks.get(i));
			}
			Collections.sort(tasks);
			
			int j = size - 1;
			ArrayList<ArrayList<Integer>> output = new ArrayList<>();
			for (int i = 0; i < size / 2; i++) {
				int x = 0;
					boolean isFound = false;
				ArrayList<Integer> pair = new ArrayList<Integer>();
				for (Entry<Integer, Integer> entry : map.entrySet() ) {
					
					if (Objects.equals(tasks.get(i), entry.getValue())) {
						x = entry.getKey();
						isFound = true;
						pair.add(x);break;
						
					}
				}
				
				if(isFound )
					map.remove(x);
				isFound = false;
					for (Entry<Integer, Integer> entry : map.entrySet() ) {
						if (Objects.equals(tasks.get(j), entry.getValue())) {
						x = entry.getKey();
						isFound = true;
						pair.add(entry.getKey());
						j--;break;
					}
				}
				if(isFound )
					map.remove(x);
				output.add(pair);
			}
	    return output;
	  }
}