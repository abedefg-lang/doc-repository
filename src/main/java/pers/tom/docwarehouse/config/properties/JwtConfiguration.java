package pers.tom.docwarehouse.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author lijia
 * @description jwt相关配置
 * @date 2021-02-01 15:04
 */
@Configuration
@ConfigurationProperties(prefix = "security.jwt")
@Data
public class JwtConfiguration {

    /**密钥*/
    private String secretKey;

    /**过期时间 单位是秒 默认是7天*/
    private Integer expireTime = 7*24*60*60;

    /**
     * 获取过期日期
     * @return 返回日期
     */
    public Date getExpireDate(){
        return new Date(expireTime*1000+System.currentTimeMillis());
    }
}
