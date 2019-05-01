package com.springjwt.springjwt.commons.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springjwt.springjwt.commons.entity.User;

public class TokenCreate {
    /**
     * Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
     * withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
     * @param user 用户
     * @return 加密后的指令
     */
    public static String getToken(User user) {
        String token;
        token= JWT
                .create()
                .withAudience(user.getId()) //这里仅存储了一个userId
                .sign(Algorithm.HMAC256(user.getPassword()));
        System.out.println(token);  //用于看看这个加密后的结果，仅限于测试，记得删除
        return token;
    }
}
