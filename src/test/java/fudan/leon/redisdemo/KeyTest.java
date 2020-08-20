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
 * @Date: 2020/7/4 20:00
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class KeyTest {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1() {
        String key = "a";
        boolean exists = redisTemplate.hasKey(key);
        System.out.println("exists = " + exists);

    }

    @Test
    public void test2() {
        String key = "a";
        redisTemplate.opsForValue().set(key, "a1");
        redisTemplate.expire(key, 60, TimeUnit.SECONDS);
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        System.out.println("expire = " + expire);
    }

    @Test
    public void test3() {
        String key = "a";
        System.out.println(redisTemplate.delete(key));

    }
}
