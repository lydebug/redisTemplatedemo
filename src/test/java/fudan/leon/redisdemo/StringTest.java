package fudan.leon.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyang27
 * @Date: 2020/7/4 19:54
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StringTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1() {
        String key = "a";
        String value = "a1";
        redisTemplate.opsForValue().set(key, value);
        System.out.println(redisTemplate.opsForValue().get(key));
    }

    @Test
    public void test2() {
        String key = "a";
        String value = "a2";
        redisTemplate.opsForValue().set(key, value, 60, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get(key));
    }

}
