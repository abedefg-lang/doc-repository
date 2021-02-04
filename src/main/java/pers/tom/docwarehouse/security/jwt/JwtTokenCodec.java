package pers.tom.docwarehouse.security.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import pers.tom.docwarehouse.security.SecurityInfo;

/**
 * @author lijia
 * @description jwt token编解码器
 * @date 2021/2/4 22:00
 */
public interface JwtTokenCodec {

    /**
     * 将security info 编码成token
     * @param securityInfo security info
     * @return 返回token
     */
    String encode(SecurityInfo securityInfo);

    /**
     * 将token解码成 security info
     * @param token token
     * @return 返回 security info
     */
    SecurityInfo decode(String token) throws JWTVerificationException;
}
