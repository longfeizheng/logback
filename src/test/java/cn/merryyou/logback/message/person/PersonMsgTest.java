package cn.merryyou.logback.message.person;

import cn.merryyou.logback.message.person.constant.OperateResult;
import cn.merryyou.logback.protobuf.JProtoBufSerializerFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2017/11/25 0025.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonMsgTest {

    @Test
    public void testProto() {
        PersonMsg p = new PersonMsg();
        p.setId(1);
        p.setAddress("北京");
        p.setAge(10);
        p.setName("张三");
        p.setOpResult(OperateResult.SUCCESS);
        log.info("p={}", p);
        byte[] bytes = JProtoBufSerializerFactory.get(PersonMsg.class).serialize(p);
        log.info("p 序列化之后={}", bytes);
        PersonMsg personMsg = JProtoBufSerializerFactory.get(PersonMsg.class).deSerialize(bytes);
        log.info("personMsg={}", personMsg);
    }
}