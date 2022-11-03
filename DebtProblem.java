import java.util.Arrays;
import java.util.HashMap;

//M,N,20
//L,M,70 
//N,L,40 
//N,K,100 
//M,N,10 
//N,M,5
//How much debt does each person owe to all users? 
//How much money is a person owed ? 
//Who is the person with the most money owed ? 
//Who is the person with the most debt ?

public class DebtProblem {
	
	public static double add(long a, byte b, double c) {
		return a+ b+ c;
	}

	public static void main(String[] args) {
		byte xx = 12;
		System.out.println(add(22L, xx, 67.00));
		
		String[] friend1 = {"M", "L","N"};
		String[] friend2 = {"N", "M","L"};
		
		int[] money = {20,70, 40};
		DebtProblem.generateData(friend1, friend2, money);
		
		owesMap.entrySet().stream().forEach(System.out::println);
		System.out.println("===========");
		lentMap.entrySet().stream().forEach(System.out::println);
		
	
		String x = lentMap.entrySet().stream().max((a, b) -> {
			if (a.getValue() == b.getValue())
				return 0;
			return a.getValue() > b.getValue() ? 1 : -1;
		}).get().getKey();
		
		String y = owesMap.entrySet().stream().max((a, b) -> {
			if (a.getValue() == b.getValue())
				return 0;
			return a.getValue() > b.getValue() ? 1 : -1;
		}).get().getKey();
		
		System.out.println("Who is the person with the most money owed : "+ x + "\nWho is the person with the most debt : " +  y);
		

	}
	
	private static HashMap<String, Integer> owesMap = new HashMap<>();
	private static HashMap<String, Integer> lentMap = new HashMap<>();
	
	private static void generateData(String[] friend1, String[] friend2, int[] money) {
		int n = friend1.length;
		for (int i = 0; i < n; i++) {
			if (owesMap.containsKey(friend1[i]) ) {
				owesMap.put(friend1[i], money[i] + owesMap.get(friend1[i]));
			}
			else {
				owesMap.put(friend1[i], money[i]);
			}
			
			if (lentMap.containsKey(friend2[i]) ) {
				lentMap.put(friend2[i], money[i] + lentMap.get(friend2[i]));
			}
			else {
				lentMap.put(friend2[i], money[i]);
			}
		}
		
	}

}
