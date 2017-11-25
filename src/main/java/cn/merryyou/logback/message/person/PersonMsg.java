package cn.merryyou.logback.message.person;

import cn.merryyou.logback.message.MessageBody;
import cn.merryyou.logback.message.person.constant.OperateResult;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.Data;

/**
 * Created on 2017/11/25 0025.
 * Person消息
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class PersonMsg implements MessageBody {

    @Protobuf(required = true)
    private Integer id;

    @Protobuf(required = true)
    private String name;

    @Protobuf(required = true)
    private Integer age;

    @Protobuf(required = true)
    private String address;

    @Protobuf(required = true)
    private OperateResult opResult;

}
