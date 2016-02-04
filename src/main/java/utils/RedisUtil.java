package utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {
	public String SimpleTest()
	{
		Jedis jedis = new Jedis("192.168.1.29", 6379);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		
		return value;
	}
}
