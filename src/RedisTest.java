import redis.clients.jedis.Jedis;

 class RedisTest {

	public static String Simple()
	{
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		
		return value;
	}
}
