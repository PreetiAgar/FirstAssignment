package rahulsaEcomPrac.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReaderUtility {

	public List<HashMap<String,String>> getJsonDataToMap() throws IOException {
		
		//read json file as string
		@SuppressWarnings("deprecation")
		String fileContent =FileUtils.readFileToString(new File(System.getProperty("user.dir")
				+"/src/test/java/rahulsaEcomPrac/data/SubmitOrder.json"),StandardCharsets.UTF_8);
		
		//Jackson Databind to convert string to HashMap
		ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(fileContent,new TypeReference<List<HashMap<String,String>>>(){});
	
	return data;
	}
}
