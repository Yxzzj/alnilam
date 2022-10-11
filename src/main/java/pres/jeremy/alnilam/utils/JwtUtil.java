package pres.jeremy.alnilam.utils;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import pres.jeremy.alnilam.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class JwtUtil {

    private static final String JWT_SIGN_KEY = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";

    public static String generateToken(UserDTO userDTO) {
        if (Objects.isNull(userDTO)) {
            throw new RuntimeException("用户不存在");
        }
        return Jwts.builder()
                .setSubject(JSON.toJSONString(userDTO))
                .setExpiration(DateTimeUtil.localDateTimeToDate(LocalDateTime.now()))
                .signWith(SignatureAlgorithm.HS256, JWT_SIGN_KEY)
                .compact();
    }

    public static UserDTO parseToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(JWT_SIGN_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        } catch (UnsupportedJwtException e) {
            throw new RuntimeException(e);
        } catch (MalformedJwtException e) {
            throw new RuntimeException(e);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        String subject = claims.getSubject();
        return JSON.parseObject(subject, UserDTO.class);
    }

    public static void main(String[] args) throws InterruptedException {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1001)
                .setName("zhangjun")
                .setUserName("admin")
                .setRole("administrator")
                .setPermission("top");
        String token = generateToken(userDTO);
        System.out.println(token);
        Thread.sleep(1000);
        UserDTO userDTO1 = parseToken(token);
        System.out.println(userDTO1);
    }
}
