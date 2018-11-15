package org.amos.swagger2.redis;

import org.amos.swagger2.BaseJunit;
import org.amos.swagger2.common.redis.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends BaseJunit{

	@Autowired
    private RedisUtils redisUtils;
	
    @Test
    public void test(){
    	
    	redisUtils.set("abc", "测试");
        System.out.println(redisUtils.get("abc"));
    }
}
