package demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {
	
	public static void main(String[] args) {

		multiLine();
		
	}
	
	public static void lineRegex(){
		
		String aStr=  " [REPLICATION_SERVERS]                                                             " +  System.lineSeparator()  
					+ " #You can have 2 instances of Open DHCP Servers in a network. Open DHCP Server     " +  System.lineSeparator() 
					+ " #will send replication inform messages to other instance of Open DHCP             " +  System.lineSeparator() 
					+ " #server and leases will be replicated. The IP address alloted by one server       " +  System.lineSeparator() 
					+ " #will not be realotted by other server to another host. Also when one server      " +  System.lineSeparator() 
					+ " #goes down, other can will renew the leases, without NAK and DISCOVER. You need   " +  System.lineSeparator() 
					+ " #to specify Primary and secondary servers for replication to work.                " +  System.lineSeparator() 
					+ " #Make sure that Primary & Secondary Server entries are identical on both          " +  System.lineSeparator() 
					+ " #servers. You may copy the entire ini file on both servers and change the         " +  System.lineSeparator() 
					+ " #LISTEN_ON on individual servers, if needed.                                      " +  System.lineSeparator() 
					+ " Primary=192.168.0.253                                                             " +  System.lineSeparator() 
					+ " Secondary=192.168.0.254                                                           " +  System.lineSeparator()  
					+ "    			" 
					+ " AAAAA		";

		String bStr = FileUtil.readToBuffer("Regex/demo/regex/opendhcp.ini");
		
		Pattern p = Pattern.compile(".*(\\[REPLICATION_SERVERS\\]).*(\r?\n)\\s*(Secondary=[\\d.]*)\\s*(\r?\n).*", Pattern.DOTALL);
		Matcher m = p.matcher(bStr);
		if (m.find()) {
			String mStr = m.group(3);
			System.out.println("+++++++++++");
			System.out.println(mStr);
			System.out.println("+++++++++++");
		}
		
		
	}
	
	public static void lineRegex2(){
		
		String aStr=  " [REPLICATION_SERVERS]                                                             " +  System.lineSeparator()  
					+ " #You can have 2 instances of Open DHCP Servers in a network. Open DHCP Server     " +  System.lineSeparator() 
					+ " #will send replication inform messages to other instance of Open DHCP             " +  System.lineSeparator() 
					+ " #server and leases will be replicated. The IP address alloted by one server       " +  System.lineSeparator() 
					+ " #will not be realotted by other server to another host. Also when one server      " +  System.lineSeparator() 
					+ " #goes down, other can will renew the leases, without NAK and DISCOVER. You need   " +  System.lineSeparator() 
					+ " #to specify Primary and secondary servers for replication to work.                " +  System.lineSeparator() 
					+ " #Make sure that Primary & Secondary Server entries are identical on both          " +  System.lineSeparator() 
					+ " #servers. You may copy the entire ini file on both servers and change the         " +  System.lineSeparator() 
					+ " #LISTEN_ON on individual servers, if needed.                                      " +  System.lineSeparator() 
					+ " Primary=192.168.0.253                                                             " +  System.lineSeparator() 
					+ " Secondary=192.168.0.254                                                           " +  System.lineSeparator()  
					+ "    			"
					+ "AAAA  		"
					+ "123  		"
					+ "1231231231231"
					+ "AAAAABBBBBBBB";

//		Pattern p = Pattern.compile(".*(^Secondary=[\\d.]*|\\s*$).*", Pattern.MULTILINE);
//		Pattern p = Pattern.compile("^A.*B$", Pattern.LITERAL);
//		Matcher m = p.matcher(aStr);
//		while(m.find()){
//			String group = m.group();
//			System.out.println(group);
//		}
		
		Pattern p = Pattern.compile("^([0-9]*).*", Pattern.MULTILINE);
		Matcher m = p.matcher(aStr);
		while (m.find()) {
		  String number = m.group(1);
		  System.out.println("+++++++++++");
		  System.out.println(number);
		  System.out.println("+++++++++++");
		}
			
//		if (m.find()) {
//			String mStr = m.group(2);
//			System.out.println("+++++++++++");
//			System.out.println(mStr);
//			System.out.println("+++++++++++");
//		}
		
		
	}
	
	public static void dotAll(){
		String aStr =     "<table border=\"1\">     " + System.lineSeparator()
						+ "  <tr>                   " + System.lineSeparator()
						+ "    <th>Month</th>       " + System.lineSeparator()
						+ "    <th>Savings</th>     " + System.lineSeparator()
						+ "  </tr>                  " + System.lineSeparator()
						+ "  <tr>                   " + System.lineSeparator()
						+ "    <td>January</td>     " + System.lineSeparator()
						+ "    <td>$100</td>        " + System.lineSeparator()
						+ "  </tr>                  " + System.lineSeparator()
						+ "</table>                 ";
		
		Pattern p = Pattern.compile("<tr>.+?</tr>", Pattern.DOTALL);
		Matcher m = p.matcher(aStr);
		
		while(m.find()){
			String group = m.group();
			System.out.println(group);
		}

	}
	
	public static void multiLine(){
		
		String aStr =     "<table border=\"1\">     " + System.lineSeparator()
						+ "<tr>                    A" + System.lineSeparator()
						+ "    <th>Month</th>       " + System.lineSeparator()
						+ "    <th>Savings</th>     " + System.lineSeparator()
						+ "</tr>                    " + System.lineSeparator()
						+ "  <tr>                   " + System.lineSeparator()
						+ "    <td>January</td>     " + System.lineSeparator()
						+ "    <td>$100</td>        " + System.lineSeparator()
						+ "  </tr>                  " + System.lineSeparator()
						+ "</table>                B";
		
//		Pattern p = Pattern.compile("^(<| ).*");
		Pattern p = Pattern.compile("^(<| ).*", Pattern.MULTILINE);
		Matcher m = p.matcher(aStr);
		
		while(m.find()){
			String group = m.group();
			System.out.println(group);
		}
		
	}
	
	
	

}
