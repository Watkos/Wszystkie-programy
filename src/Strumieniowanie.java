import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class Strumieniowanie {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Roman", "Marek", "Emilka", "Mateusz", "Anna", "Ebeebe");
		List<String> names1 = Arrays.asList("kobieta", "Roman", "mezczyzna");
		long a = names.stream().filter(s->s.contains("om")).count();
		System.out.println(a);
		
		//names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).limit(1).forEach(s->System.out.println(s));
		//names.stream().filter(s->s.startsWith("E")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Stream<String> mergedStream = Stream.concat(names.stream(), names1.stream());
		//boolean flag = mergedStream.anyMatch(s->s.equalsIgnoreCase("Roman"));
		//Assert.assertTrue(flag);
		//mergedStream.filter(s->s.endsWith("a")).forEach(s->System.out.println(s));
	}

}
