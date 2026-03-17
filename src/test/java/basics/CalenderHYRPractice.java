package basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalenderHYRPractice {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String inputDate = "30-February-2021";
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MMM-yyyy"); //creating a simple date format
		
		//Date formattedInputDate= inputDateFormat.parse(inputDate); //passing the date in created format so that Java can also understand
		//System.out.println(formattedInputDate);
		//Validating user input date is correct or not. Ex-30th Feb will give result as 2nd Mar
		Date formattedInputDate;
		try {
			inputDateFormat.setLenient(false);
			formattedInputDate=inputDateFormat.parse(inputDate);
		}catch(ParseException e) {
			
			throw new Exception ("User input date is invalid");
		
		}
	}

}
