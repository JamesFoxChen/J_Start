package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static String GetCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String d = df.format(new Date());
		System.out.println(d);
		return d;
	}

	public static int CalWeekInternal(String start, String end) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		long startTime = 0;
		long endTime = 0;
		try {
			startTime = df.parse(start).getTime();
			endTime = df.parse(end).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int week = (int) ((endTime - startTime) / (1000 * 3600 * 24 * 7));
		return week;
	}
}
