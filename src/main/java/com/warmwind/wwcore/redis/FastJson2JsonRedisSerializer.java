package com.warmwind.wwcore.redis;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import com.warmwind.wwcore.core.constants.Constants;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * Redis使用FastJson序列化
 *
 * @author warmwind
 * @createTime 2024-02-28 23:33
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    /**
     * 默认字符集为 UTF-8
     */
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    /**
     * FastJson 默认使用的类型过滤器，可以根据白名单配置来防止恶意反序列化
     */
    static final Filter AUTO_TYPE_FILTER = JSONReader.autoTypeFilter(Constants.JSON_WHITELIST_STR);

    /**
     * 需要序列化/反序列化的对象类型
     */
    private Class<T> clazz;

    /**
     * 构造函数，传入需要序列化/反序列化的对象类型
     *
     * @param clazz 对象类型
     */
    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    /**
     * 将对象序列化为字节数组
     *
     * @param t 待序列化的对象
     * @return 序列化后的字节数组
     * @throws SerializationException 序列化异常
     */
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        // 使用 FastJson 将对象转为 JSON 字符串，并添加类名信息
        return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    /**
     * 将字节数组反序列化为对象
     *
     * @param bytes 待反序列化的字节数组
     * @return 反序列化后的对象
     * @throws SerializationException 反序列化异常
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        // 将字节数组转为字符串
        String str = new String(bytes, DEFAULT_CHARSET);
        // 使用 FastJson 将 JSON 字符串反序列化为对象，通过 AUTO_TYPE_FILTER 防止恶意反序列化
        return JSON.parseObject(str, clazz, AUTO_TYPE_FILTER);
    }
}
