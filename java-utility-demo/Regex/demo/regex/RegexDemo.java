package demo.regex;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) throws Exception {
		
		String encode = URLEncoder.encode("http://localhost:8080/WebApp?a=A", "utf-8");
		System.out.println(encode);

		String txt = "http://localhost:8080/WebApp?aKey=A&b=B&c=C";

		String key = "b";
		String value = getKeyValue(txt, key);
		System.out.println("key's value is " + value);

	}

	public static String getKeyValue(String txt, String key) throws Exception {
		String regex = "\\S*\\??((\\S+?)=(\\S+?))";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		
		while (matcher.find()) {
			System.out.println("matcher.group(1):" + matcher.group(1));
			System.out.println("matcher.group(2):" + matcher.group(2));
			System.out.println("matcher.group(3):" + matcher.group(3));
			if (key.trim().equals(matcher.group(2))){
				return matcher.group(3);
			}
		}
		return null;
	}

}
