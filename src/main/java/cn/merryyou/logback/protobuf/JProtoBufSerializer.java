package cn.merryyou.logback.protobuf;

import cn.merryyou.logback.exception.CommonException;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * Created on 2017/11/25 0025.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class JProtoBufSerializer<T extends JProtoBufBean> implements Serializer<T> {

    private Codec<T> codec;

    JProtoBufSerializer(Class<T> clz) {
        codec = ProtobufProxy.create(clz);
    }

    @Override
    public byte[] serialize(T obj) throws CommonException {
        Assert.notNull(obj);

        try {
            return codec.encode(obj);
        }
        catch (IOException e) {
            throw new CommonException("序列化对象失败", e);
        }
    }

    @Override
    public T deSerialize(byte[] bytes) throws CommonException {
        Assert.notNull(bytes);

        try {
            return codec.decode(bytes);
        }
        catch (IOException e) {
            throw new CommonException("反序列化对象失败", e);
        }
    }
}
