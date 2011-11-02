package log4j;

import java.io.*;
import java.net.*;

/**
 * 
 * <p>
 * Client Without Log4j
 * </p>
 * <p>
 * Description: a sample with log4j
 * </p>
 * 
 * @version 1.0
 */
public class ClientWithoutLog4j {

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		String welcome = null;
		String response = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		InputStream in = null;
		OutputStream out = null;
		Socket client = null;
		try {
			client = new Socket("localhost", 8001);
			System.out.println("info: Client socket: " + client);
			in = client.getInputStream();
			out = client.getOutputStream();
		} catch (IOException e) {
			System.out.println("error: IOException : " + e);
			System.exit(0);
		}

		try {
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(new OutputStreamWriter(out), true);
			welcome = reader.readLine();
			System.out.println("debug: Server says: '" + welcome + "'");
			System.out.println("debug: HELLO");
			writer.println("HELLO");
			response = reader.readLine();
			System.out.println("debug: Server responds: '" + response + "'");
			System.out.println("debug: HELP");
			writer.println("HELP");
			response = reader.readLine();
			System.out.println("debug: Server responds: '" + response + "'");
			System.out.println("debug: QUIT");
			writer.println("QUIT");
		} catch (IOException e) {
			System.out.println("warn: IOException in client.in.readln()");
			System.out.println(e);
		}

		try {
			Thread.sleep(2000);
		} catch (Exception ignored) {

		}

	}

}
