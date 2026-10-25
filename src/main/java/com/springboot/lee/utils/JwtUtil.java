package com.springboot.lee.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具類
 */
public class JwtUtil {

    //有效期限
    public static final Long JWT_TTL = 60 * 60 *1000L;// 60 * 60 *1000  一个小时
    //設置密鑰
    public static final String JWT_KEY = "yuanHaoLEE";

    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * 生成jtw
     * @param subject token中要存放的數據（json格式）
     * @return
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());// 設置過期時間
        return builder.compact();
    }

    /**
     * 生成jtw
     * @param subject token中要存放的數據（json格式）
     * @param ttlMillis token超時時間
     * @return
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());// 設置過期時間
        return builder.compact();//.compact() 這個方法，就是負責執行最後的「組裝與字串化」步驟
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis=JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
        .setId(uuid)              	// 唯一的ID
        .setSubject(subject)   		// 主题  可以是JSON数据
        .setIssuer("LEE")     		// 簽發者
        .setIssuedAt(now)      		// 簽發時間
        .signWith(signatureAlgorithm, secretKey) //使用HS256對稱加密算法簽名, 第二个參數為密鑰
        .setExpiration(expDate);
    }

    /**
     * 創建token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);// 設置過期時間
        return builder.compact();
    }

    public static void main(String[] args) throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjZTZlOWRhMDA1YTM0YzYyYWY3YmRhMDE2ZTkxNDQ5ZCIsInN1YiI6IjIiLCJpc3MiOiJzZyIsImlhdCI6MTc5MTE4MDgwMiwiZXhwIjoxNzkxMTg0NDAyfQ.vmxlFZPV0_CNHBq9UUQWFCuUrk8GNJMTIgXtnC0EDn4";
        Claims claims = parseJWT(token);
        String subject = claims.getSubject();
        System.out.println(subject);
    }

    /**
     * 生成加密後的密鑰 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(jwt)
        .getBody();
    }

}