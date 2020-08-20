package fudan.leon.redisdemo;

import fudan.leon.redisdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: liyang27
 * @Date: 2020/7/7 16:48
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ObjectTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        User user = new User();
        user.setUserName("leon");
        user.setAge(22);
        redisTemplate.opsForValue().set(user.getUserName(), user);
        log.info("result:{}", redisTemplate.opsForValue().get("leon"));
    }
}
