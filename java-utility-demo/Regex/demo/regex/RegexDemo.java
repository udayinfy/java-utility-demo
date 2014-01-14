package demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) throws Exception {
		
//		String encode = URLEncoder.encode("http://localhost:8080/WebApp?a=A", "utf-8");
//		System.out.println(encode);

		String txt = "http://localhost:8080/WebApp?aKey=A&b=B&c=C";
		String key = "b";
		String value = getKeyValue(txt, key);
		System.out.println("key's value is " + value);
		
//		String txt = "http://www.google.com.hk/#hl=zh-CN&newwindow=1&safe=strict&tbo=d&q=java+%E6%AD%A3%E5%88%99+URL&oq=java+%E6%AD%A3%E5%88%99+URL&gs_l=serp.3..0i30j0i8i30l9.1163177.1171621.0.1172528.22.14.8.0.0.0.199.1189.5j6.11.0...0.0...1c.1j4.c2d1aoFaWOQ&bav=on.2,or.r_gc.r_pw.&bvm=bv.41642243,d.aGc&fp=a2d9cfec83f3b51d&biw=1366&bih=667";
//		boolean b = isURL(txt);
//		System.out.println(b);

	}

	public static String getKeyValue(String txt, String key) throws Exception {
		String regex = "(\\S+?\\?)(\\S*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		
		while (matcher.find()) {
			System.out.println("matcher.group(1):" + matcher.group(1));
			System.out.println("matcher.group(2):" + matcher.group(2));
		}
		return null;
	}
	
	public static boolean isURL(String txt){
		 Pattern pattern = Pattern.compile("^(http|www|ftp|)?(://)?(//w+(-//w+)*)(//.(//w+(-//w+)*))*((://d+)?)(/(//w+(-//w+)*))*(//.?(//w)*)(//?)?(((//w*%)*(//w*//?)*(//w*:)*(//w*//+)*(//w*//.)*(//w*&)*(//w*-)*(//w*=)*(//w*%)*(//w*//?)*(//w*:)*(//w*//+)*(//w*//.)*(//w*&)*(//w*-)*(//w*=)*)*(//w*)*)$",Pattern.CASE_INSENSITIVE );
		 Matcher matcher = pattern.matcher(txt);
		 if (matcher.find()) {
			System.out.println(matcher.group());
			return true;
		}
		 return false;
	}

}
