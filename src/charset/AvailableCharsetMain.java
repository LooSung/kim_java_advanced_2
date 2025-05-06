package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;

public class AvailableCharsetMain {

	public static void main(String[] args) {
		System.out.println("Available Charset");
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		for (String key : charsets.keySet()) {
			System.out.println(key + ": " + charsets.get(key));
		}

		Charset set1 = Charset.forName("MS949");
		System.out.println("Charset1 : " + set1);

		Charset set2 = StandardCharsets.UTF_32;
		System.out.println("Charset2 : " + set2);

		Charset set3 = Charset.defaultCharset();
		System.out.println("Charset3 : " + set3);
	}
}
