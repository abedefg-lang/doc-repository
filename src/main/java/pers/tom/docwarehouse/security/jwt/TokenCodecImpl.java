package pers.tom.docwarehouse.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import pers.tom.docwarehouse.security.SecurityInfo;

import java.util.Date;

/**
 * @author tom
 * @description
 * @date 2021/2/4 22:03
 */
@Component
public class TokenCodecImpl implements JwtTokenCodec{

    private final JwtConfiguration jwtConfiguration;

    public TokenCodecImpl(JwtConfiguration jwtConfiguration) {
        this.jwtConfiguration = jwtConfiguration;
    }

    @Override
    public String encode(SecurityInfo securityInfo) {

        Date expireDate = new Date(jwtConfiguration.getExpireTime()*1000 + System.currentTimeMillis());
        String token = JWT.create()
                .withClaim(SecurityInfo.IDENTITY_NAME, securityInfo.getIdentity())
                .withClaim(SecurityInfo.IDENTITY_INFO_NAME, securityInfo.getIdentityInfo())
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(jwtConfiguration.getSignSecretKey()));

        //进行加密

        return token;
    }

    @Override
    public SecurityInfo decode(String token) throws JWTVerificationException {

        //进行解密

        //验证token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(jwtConfiguration.getSignSecretKey())).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        //获取身份唯一标识 身份标识描述
        Long identity = decodedJWT.getClaim(SecurityInfo.IDENTITY_NAME).asLong();
        String identityInfo = decodedJWT.getClaim(SecurityInfo.IDENTITY_INFO_NAME).asString();
        if(identity != null && identityInfo != null){
            return new SecurityInfo(identity, identityInfo);
        }
        return null;
    }
}
