package com.william.spt.utils;

import com.william.admin.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: william
 * @Date: 2018/2/28 15:58
 */
public class JwtUtils {

    public static Claims parseJWT(String jsonWebToken){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey("mySecret")
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch(Exception ex) {
            return null;
        }
    }

    public static String createJWT(User user) {

        long nowMillis = System.currentTimeMillis();
        Date createdDate = new Date(nowMillis);
        final Date expirationDate = new Date(createdDate.getTime() + 604800 * 1000);

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .claim("userName", user.getUserName())
                .claim("userId", user.getId())
                .setSubject(user.getUserName())
                .setAudience("web")
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, "mySecret");

        //生成JWT
        return builder.compact();
    }
}
