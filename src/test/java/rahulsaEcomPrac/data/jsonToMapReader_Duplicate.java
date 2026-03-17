package rahulsaEcomPrac.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonToMapReader_Duplicate {
//convert json to string using FileUtils class readtoString method
	//read string to map as pass as list using Jackson databind's Object mapper class 
	public List<HashMap<String,String>> getData() throws IOException {
		String jsonContent=FileUtils.readFileToString(new File (System.getProperty("user.dir")+
				"//src//test//java//rahulsaEcomPrac//data//SubmitOrder.json"),StandardCharsets.UTF_8);
		
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String,String>> data=map.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
		
	}
}
