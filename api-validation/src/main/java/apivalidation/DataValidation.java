package apivalidation;

import java.util.HashMap;
public class DataValidation {
	private static HashMap<String,String> dataValidationMap = new HashMap<String,String>();;
	public DataValidation()
	{
		dataValidationMap = new HashMap<String,String>();
	}

	public static void setData(String key, String validationString)
	{
		if(key!= null && validationString!= null)
		{
			dataValidationMap.put(key,validationString);
		}
	}
	public static String getValidationString(String key)
	{
		String validationString = "";
		if(dataValidationMap.containsKey(key))
		{
			validationString = dataValidationMap.get(key);
		}
		return validationString;
	}
	/*public static void main(String[] args)
	{
		setData("avc","def");
		String abc=getValidationString("avc");
		System.out.println(abc);
	}*/
}
