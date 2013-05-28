import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonDemo {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		Map<String, Object> userInMap = new HashMap<String, Object>();
		userInMap.put("name", "mkyong");
		userInMap.put("age", 29);

		List<Object> list = new ArrayList<Object>();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");

		userInMap.put("messages", list);

		try {

			// write JSON to a file
			mapper.writeValue(new File("D:\\user.json"), userInMap);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
