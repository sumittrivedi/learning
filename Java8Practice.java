import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 3, 5, 10, 16, 8, null);
		System.out.println(
				list.stream().filter( x -> Optional.ofNullable(x).isPresent() && x > 5).collect(Collectors.toList()));
		
		List<String> list2 = Arrays.asList("abc", " ", "def", " ", "ghz");
		System.out.println(
				list2.stream().filter( x -> !x.isBlank()).collect(Collectors.toList()));
	}

}
