package cn.merryyou.logback.protobuf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2017/11/25 0025.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class JProtoBufSerializerFactory {
    private static Map<Class, JProtoBufSerializer> map = new HashMap<Class, JProtoBufSerializer>();

    private JProtoBufSerializerFactory() {}

    public static <T extends JProtoBufBean> JProtoBufSerializer<T> get(Class<T> clz) {
        JProtoBufSerializer<T> serializer = map.get(clz);

        if (serializer == null) {
            serializer = new JProtoBufSerializer<T>(clz);
            map.put(clz, serializer);
        }

        return serializer;
    }
}
