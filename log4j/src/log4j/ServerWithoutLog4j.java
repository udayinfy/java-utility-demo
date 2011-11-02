package log4j;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 * 
 * <p>
 * Server Without Log4j
 * </p>
 * <p>
 * Description: a sample with log4j
 * </p>
 * 
 * @version 1.0
 */
public class ServerWithoutLog4j {

	final static int SERVER_PORT = 8001; // this server's port

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		String clientRequest = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		ServerSocket server = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		try {
			server = new ServerSocket(SERVER_PORT);
			System.out.println("info: ServerSocket before accept: " + server);
			System.out.println("info: Java server without log4j, on-line!");
			// wait for client's connection
			socket = server.accept();
			System.out.println("info: ServerSocket after accept: " + server);
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			System.out.println("error: Server constructor IOException: " + e);
			System.exit(0);
		}

		reader = new BufferedReader(new InputStreamReader(in));
		writer = new PrintWriter(new OutputStreamWriter(out), true);
		// send welcome string to client
		writer.println("Java server without log4j, " + new Date());

		while (true) {
			try {
				// read from client
				clientRequest = reader.readLine();
				System.out.println("debug: Client says: " + clientRequest);
				if (clientRequest.startsWith("HELP")) {
					System.out.println("debug: OK!");
					writer.println("Vocabulary: HELP QUIT");
				} else {
					if (clientRequest.startsWith("QUIT")) {
						System.out.println("debug: OK!");
						System.exit(0);
					} else {
						System.out.println("warn: Command '" + clientRequest
								+ "' not understood.");
						writer.println("Command '" + clientRequest
								+ "' not understood.");
					}
				}
			} catch (IOException e) {
				System.out.println("error: IOException in Server " + e);
				System.exit(0);
			}
		}
	}
}
