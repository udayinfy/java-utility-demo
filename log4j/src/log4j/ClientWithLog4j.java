package log4j;

import java.io.*;
import java.net.*;
// add for log4j: import some package
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

/**
 * 
 * <p>
 * Client With Log4j
 * </p>
 * <p>
 * Description: a sample with log4j
 * </p>
 * 
 * @version 1.0
 */
public class ClientWithLog4j {

	/*
	 * add for log4j: class Logger is the central class in the log4j package. we
	 * can do most logging operations by Logger except configuration.
	 * getLogger(...): retrieve a logger by name, if not then create for it.
	 */
	static Logger logger = Logger.getLogger(ClientWithLog4j.class.getName());

	/**
	 * 
	 * @param args
	 *            : configuration file name
	 */
	public static void main(String args[]) {

		String welcome = null;
		String response = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		InputStream in = null;
		OutputStream out = null;
		Socket client = null;
		/*
		 * add for log4j: class BasicConfigurator can quickly configure the
		 * package. print the information to console.
		 */
		PropertyConfigurator.configure("src/ClientWithLog4j.properties");
		// add for log4j: set the level
		// logger.setLevel ( ( Level ) Level.DEBUG ) ;
		try {
			client = new Socket("localhost", 8001);
			// add for log4j: log a message with the info level
			logger.info("Client socket: " + client);
			in = client.getInputStream();
			out = client.getOutputStream();
		} catch (IOException e) {
			// add for log4j: log a message with the error level
			logger.error("IOException : " + e);
			System.exit(0);
		}

		try {
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(new OutputStreamWriter(out), true);
			welcome = reader.readLine();
			// add for log4j: log a message with the debug level
			logger.debug("Server says: '" + welcome + "'");

			// add for log4j: log a message with the debug level
			logger.debug("HELLO");
			writer.println("HELLO");
			response = reader.readLine();
			// add for log4j: log a message with the debug level
			logger.debug("Server responds: '" + response + "'");

			// add for log4j: log a message with the debug level
			logger.debug("HELP");
			writer.println("HELP");
			response = reader.readLine();
			// add for log4j: log a message with the debug level
			logger.debug("Server responds: '" + response + "'");

			// add for log4j: log a message with the debug level
			logger.debug("QUIT");
			writer.println("QUIT");

		} catch (IOException e) {
			// add for log4j: log a message with the warn level
			logger.warn("IOException in client.in.readln()");
			System.out.println(e);
		}

		try {
			Thread.sleep(2000);
		} catch (Exception ignored) {

		}

	}

}
