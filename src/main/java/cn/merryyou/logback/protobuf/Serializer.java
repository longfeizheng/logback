package cn.merryyou.logback.protobuf;

import cn.merryyou.logback.exception.CommonException;

/**
 * Created on 2017/11/25 0025.
 * 序列器，用于缓存对象序列化和反序列化
 * （当前redis缓存时，key一律使用字符串，value使用byte数组）
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface Serializer<T> {
    byte[] serialize(T obj) throws CommonException;

    T deSerialize(byte[] bytes) throws CommonException;
}
