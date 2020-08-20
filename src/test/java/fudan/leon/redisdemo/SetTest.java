package fudan.leon.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @Author: liyang27
 * @Date: 2020/7/5 09:54
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SetTest {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1() {
        String key = "myset";
        String v1 = "a1";
        String v2 = "a1";
        String v3 = "a2";
        redisTemplate.opsForSet().add(key, v1, v2, v3);
        Set<Object> set = redisTemplate.opsForSet().members(key);
        System.out.println("set = " + set);
    }

    @Test
    public void test3() {
        String key = "myset";
        System.out.println(redisTemplate.opsForSet().isMember("myset", "a1"));
    }
}
