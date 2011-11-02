package log4j;

import java.util.*;
import java.io.*;
import java.net.*;
// add for log4j: import some package
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

/**
 * 
 * <p>
 * Server With Log4j
 * </p>
 * <p>
 * Description: a sample with log4j
 * </p>
 * 
 * @version 1.0
 */
public class ServerWithLog4j {

	final static int SERVER_PORT = 8001; // this server's port
	/*
	 * add for log4j: class Logger is the central class in the log4j package. we
	 * can do most logging operations by Logger except configuration.
	 * getLogger(...): retrieve a logger by name, if not then create for it.
	 */
	static Logger logger = Logger.getLogger(ServerWithLog4j.class.getName());

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
		/*
		 * add for log4j: class BasicConfigurator can quickly configure the
		 * package. print the information to console.
		 */
		PropertyConfigurator.configure("src/ServerWithLog4j.properties");
		// add for log4j: set the level
		// logger.setLevel ( ( Level ) Level.DEBUG ) ;
		try {
			server = new ServerSocket(SERVER_PORT);
			// add for log4j: log a message with the info level
			logger.info("ServerSocket before accept: " + server);
			// add for log4j: log a message with the info level
			logger.info("Java server with log4j, on-line!");
			// wait for client's connection
			socket = server.accept();
			// add for log4j: log a message with the info level
			logger.info("ServerSocket after accept: " + server);
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			// add for log4j: log a message with the error level
			logger.error("Server constructor IOException: " + e);
			System.exit(0);
		}

		reader = new BufferedReader(new InputStreamReader(in));
		writer = new PrintWriter(new OutputStreamWriter(out), true);
		// send welcome string to client
		writer.println("Java server with log4j, " + new Date());

		while (true) {
			try {
				// read from client
				clientRequest = reader.readLine();
				// add for log4j: log a message with the debug level
				logger.debug("Client says: " + clientRequest);
				if (clientRequest.startsWith("HELP")) {
					// add for log4j: log a message with the debug level
					logger.debug("OK!");
					writer.println("Vocabulary: HELP QUIT");
				} else {
					if (clientRequest.startsWith("QUIT")) {
						// add for log4j: log a message with the debug level
						logger.debug("OK!");
						System.exit(0);
					} else {
						// add for log4j: log a message with the warn level
						logger.warn("Command '" + clientRequest
								+ "' not understood.");
						writer.println("Command '" + clientRequest
								+ "' not understood.");
					}
				}
			} catch (IOException e) {
				// add for log4j: log a message with the error level
				logger.error("IOException in Server " + e);
				System.exit(0);
			}
		}

	}

}
