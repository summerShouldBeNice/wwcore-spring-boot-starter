package com.warmwind.wwcore.jwt;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author warmwind
 * @createTime 2024-02-29 00:04
 */
@Component
public class WwcoreJwtUtils {

    private WwcoreJwtProperties coreJwtProperties;

    public WwcoreJwtProperties getCoreJwtProperties() {
        return coreJwtProperties;
    }

    public void setCoreJwtProperties(WwcoreJwtProperties coreJwtProperties) {
        this.coreJwtProperties = coreJwtProperties;
    }

    /**
     * 生成token
     * @param t
     * @return
     * @param <T>
     */
    public <T> String createToken(T t) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, coreJwtProperties.getExpire());
        JWTCreator.Builder builder =
                JWT.create()
                        .withClaim(t.getClass().getSimpleName(), JSON.toJSONString(t))
                        .withExpiresAt(instance.getTime());
        // 签名
        String token = builder.sign(Algorithm.HMAC256(coreJwtProperties.getSecret()));
        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public DecodedJWT verifyToken(String token) {
        DecodedJWT decodedJWT;
        try {
            decodedJWT = JWT.require(Algorithm.HMAC256(coreJwtProperties.getSecret()))
                    .build().verify(token);
        }catch (RuntimeException runtimeException) {
            throw new RuntimeException();
        }
        return decodedJWT;
    }

    /**
     * 解析token
     * @param decodedJWT
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T parseToken(DecodedJWT decodedJWT, Class<T> clazz){
        // 与放入时的声明一致
        Claim claim = decodedJWT.getClaim(clazz.getSimpleName());
        if (claim == null){
            return null;
        }
        return JSON.parseObject(claim.asString(), clazz);
    }

}
