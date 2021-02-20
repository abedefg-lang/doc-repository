package pers.tom.docwarehouse.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijia
 * @description jwt相关配置
 * @date 2021-02-01 15:04
 */
@Configuration
@ConfigurationProperties(prefix = "security.jwt")
@Data
public class JwtConfiguration {


    /**签名密钥*/
    private String signSecretKey;

    /**过期时间 单位是秒 默认是7天*/
    private Integer expireTime = 7*24*60*60;

}
