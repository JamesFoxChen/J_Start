package utils;

import java.text.DateFormat;
import java.util.Date;

public class StringUtil {
	public static String AppendCurrentDate(String str)
	{
		  Date now = new Date(); 
		  
		  DateFormat d2 = DateFormat.getInstance(); 
		  return str+"_"+ d2.format(now);
	}
}
