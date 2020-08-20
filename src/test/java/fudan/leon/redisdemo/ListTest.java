package fudan.leon.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: liyang27
 * @Date: 2020/7/5 09:44
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ListTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1() {
        String key = "letters";
        redisTemplate.opsForList().leftPush(key, "a");
        redisTemplate.opsForList().leftPush(key, "b");
        redisTemplate.opsForList().rightPush(key, "c");
        redisTemplate.opsForList().rightPush(key, "d");
        List<Object> list = redisTemplate.opsForList().range(key, 0, -1);
        System.out.println("list = " + list);
    }

    @Test
    public void test2() {
        String key = "letters";
        System.out.println(redisTemplate.opsForList().leftPop(key));
    }
}
