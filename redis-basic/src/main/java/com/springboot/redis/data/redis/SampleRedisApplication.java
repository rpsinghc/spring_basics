/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.springboot.redis.data.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
@EnableAutoConfiguration
public class SampleRedisApplication implements CommandLineRunner {

	@Autowired
	private RedisTemplate template;

	@Override
	public void run(String... args) throws Exception {

		ValueOperations<String, String> ops = template.opsForValue();
		String key = "spring.boot.redis.test";
		if (!template.hasKey(key)) {
			ops.set(key, "foo");
		}
		System.out.println("Found key " + key + ", value=" + ops.get(key));

		HashOperations<String,String, String>  hops = template.opsForHash();
		hops.put("session1", "appid", "app1");
		hops.put("session1", "requestid", "rt");

		hops.put("session2", "appid", "app3");
		hops.put("session2", "requestid", "xfgtxx");

		Map<String,String> map = hops.entries("session1");
		System.out.println(map);
	}

	public static void main(String[] args) throws Exception {
		// Close the context so it doesn't stay awake listening for redis
		SpringApplication.run(SampleRedisApplication.class, args).close();
	}
}
