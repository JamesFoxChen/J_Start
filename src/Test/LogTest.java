package Test;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.junit.Test;

import Utils.LogUtil;


public class LogTest {

	@Test
	public void Log() {
		LogUtil.debug("debug msg");
		LogUtil.error("debug msg");
		LogUtil.info("debug msg");
	}
}
