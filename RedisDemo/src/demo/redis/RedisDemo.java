package demo.redis;

import redis.clients.jedis.Jedis;

public class RedisDemo {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.254.128:6379");
		jedis.set("key1", "value1");
		String s = jedis.get("key1");
		System.out.println(s);
	}

}
