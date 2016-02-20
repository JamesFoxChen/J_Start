package test;
import org.joda.time.DateTime;
import org.junit.Test;

public class JodaTimeTest {

	@Test
	public void test() {
		DateTime dateTime = new DateTime(2012, 12, 13, 18, 23, 55);
		String str = dateTime.toString("MM/dd/yyyy hh:mm:ss");
		System.err.println(str);
	}

	
	@Test
	public void Now()
	{
		DateTime dt = DateTime.now();
		String string=String.format("年:%s 月:%s 日:%s 时:%s 分:%s 秒:%s", 
										dt.getYear(),
										dt.getMonthOfYear(),
										dt.getDayOfMonth(),
										dt.getHourOfDay(),
										dt.getMinuteOfHour(),
										dt.getSecondOfMinute());
		
		System.err.println(string);
		
	}
	
	@Test
	public void Add()
	{
		DateTime dt = DateTime.now();
		String string=dt.plusDays(2).toString();
		System.err.println(string);
		
	}
	
	@Test
	public void Subtract()
	{
		DateTime dt = DateTime.now();
		String string=dt.plusDays(-5).toString();
		System.err.println(string);
		
	}
	
}
