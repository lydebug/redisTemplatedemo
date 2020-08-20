package fudan.leon.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liyang27
 * @Date: 2020/7/5 09:17
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HashTest {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1() {
        String key = "letter";
        String item = "a";
        String value = "a1";
        redisTemplate.opsForHash().putIfAbsent(key, item, value);
        Object v = redisTemplate.opsForHash().get(key, item);
        System.out.println("v = " + v);
    }

    @Test
    public void test2() {
        String key = "letter";
        String item = "b";
        String value = "b1";
        Map<String, Object> map = new HashMap<>();
        map.put(item, value);
        redisTemplate.opsForHash().putAll(key, map);
        Map<Object, Object> map1 = redisTemplate.opsForHash().entries(key);
        System.out.println(map1);
    }

    @Test
    public void test3() {
        String key = "letter";
        String item = "a";
        redisTemplate.opsForHash().delete(key, item);
        boolean exist = redisTemplate.opsForHash().hasKey(key, item);
        System.out.println("exist = " + exist);
    }
}
