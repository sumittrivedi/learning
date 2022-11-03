import java.util.TreeMap;

class Parent {
	{
		System.out.println("A");
	}
	static {
		System.out.println("B");
	}
}

public class ParentChild extends Parent{
	
	{
		System.out.println("C");
	}
	static {
		System.out.println("D");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent x = new ParentChild();
	}

}
