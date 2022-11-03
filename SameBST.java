import java.util.*;
import java.util.stream.Collectors;

class SameBST {
	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if (arrayOne.size() == 0 && arrayTwo.size() == 0)
			return true;
		if (arrayOne.size() != arrayTwo.size() || arrayOne.get(0) != arrayTwo.get(0))
			return false;
		arrayOne.forEach(System.out::println);
		System.out.println("\n");
		List<Integer> arrayOneLeft = arrayOne.stream().filter(x -> x < arrayOne.get(0)).collect(Collectors.toList());
				//getSmaller(arrayOne);
		List<Integer> arrayTwoLeft = arrayTwo.stream().filter(x -> x < arrayTwo.get(0)).collect(Collectors.toList());
				//getSmaller(arrayTwo);
		List<Integer> arrayOneRight = 
				arrayOne.stream().filter(x -> x >= arrayOne.get(0)).collect(Collectors.toList());
//				getLarger(arrayOne);
		List<Integer> arrayTwoRight = 
			getLarger(arrayTwo);
		//arrayTwo.stream().filter(x -> x >= arrayTwo.get(0)).collect(Collectors.toList());
		return sameBsts(arrayOneLeft, arrayTwoLeft) && sameBsts(arrayOneRight, arrayTwoRight);
	}

	private static List<Integer> getLarger(List<Integer> array) {
		List<Integer> smallerElements = new ArrayList<>();
		for (int i = 1; i < array.size(); i++) {
			if (array.get(0) > array.get(i))
				smallerElements.add(array.get(i));
		}
		return smallerElements;
	}

	private static List<Integer> getSmaller(List<Integer> array) {
		List<Integer> largerElements = new ArrayList<>();
		for (int i = 1; i < array.size(); i++) {
			if (array.get(0) <= array.get(i))
				largerElements.add(array.get(i));
		}
		return largerElements;
	}

public static void main(String args[]) {
	  
	  List<Integer> arrayOne = new ArrayList<>(); 
	  arrayOne.add(10);
	  arrayOne.add(15);
	  arrayOne.add(8);
	  arrayOne.add(12);
	  arrayOne.add(94);
	  arrayOne.add(81);
	  arrayOne.add(5);
	  arrayOne.add(2);
	  arrayOne.add(11);
	  List<Integer> arrayTwo = new ArrayList<>();
	  arrayTwo.add(10);
	  arrayTwo.add(8);
	  arrayTwo.add(5);
	  arrayTwo.add(15);
	  arrayTwo.add(2);
	  arrayTwo.add(12);
	  arrayTwo.add(11);
	  arrayTwo.add(94);
	  arrayTwo.add(81);
	 // List<Integer> arrayOneLeft = arrayOne.stream().filter(x -> x < arrayOne.get(0)).collect(Collectors.toList());
	 // arrayOneLeft.forEach(System.out::println);
	  System.out.println(SameBST.sameBsts(arrayOne, arrayTwo));
	
}
}
