import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sortowanie_liczb_stream {

	public static void main(String[] args) {
		List<Integer> nrs = Arrays.asList(3,6,5,4,2,2,6,5,1);
		//Set<Integer> sortedNrs = nrs.stream().sorted().collect(Collectors.toSet());
		//System.out.println(sortedNrs);
		nrs.stream().distinct().sorted().forEach(s->System.out.println(s));
	}

}
