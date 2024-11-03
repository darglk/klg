package com.klg.client.security;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfiguraiton {

	@Bean
	public JedisPool jedisPool(@Value("${spring.redis.port}") String port) {
		final JedisPoolConfig poolConfig = buildPoolConfig();
		return new JedisPool(poolConfig, "localhost", Integer.parseInt(port));
	}

	private JedisPoolConfig buildPoolConfig() {
		final JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(128);
		poolConfig.setMaxIdle(128);
		poolConfig.setMinIdle(16);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		poolConfig.setTestWhileIdle(true);
		poolConfig.setMinEvictableIdleDuration(Duration.ofSeconds(60));
		poolConfig.setTimeBetweenEvictionRuns(Duration.ofSeconds(30));
		poolConfig.setNumTestsPerEvictionRun(3);
		poolConfig.setBlockWhenExhausted(true);
		return poolConfig;
	}
}