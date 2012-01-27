package demo.brace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Brace {

	@Test
	public void test() {
		Map<String, String> map = new HashMap<String, String>() {
			{
				put("Name", "Unmi");
				put("QQ", "1125535");
			}
		};

		List<String> stooges = new ArrayList<String>() {
			{
				add("Larry");
				add("Moe");
				add("Curly");
			}
		};
	}

	public static void main(String[] args) {
		Set<String> validCodes = new HashSet<String>();

		validCodes.add("XZ13s");
		validCodes.add("AB21/X");
		validCodes.add("YYLEX");
		validCodes.add("AR2D");

		removeProductsWithCodeIn(validCodes);

		removeProductsWithCodeIn(new HashSet<String>() {
			{
				add("XZ13s");
				add("AB21/X");
				add("YYLEX");
				add("AR5E");
			}
		});
	}

	private static final Set<String> VALID_CODES = new HashSet<String>() {
		{
			add("XZ13s");
			add("AB21/X");
			add("YYLEX");
			add("AR2D");
		}
	};

	public static void removeProductsWithCodeIn(Collection<String> c) {

	}

}
