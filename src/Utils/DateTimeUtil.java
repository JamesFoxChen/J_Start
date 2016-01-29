package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;




public class DateTimeUtil {
	public static String GetCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
}
