package pers.tom.docwarehouse.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author lijia
 * @description 数据访问层相关的config配置
 * @date 2021-01-29 14:31
 */
@Configuration
public class RepositoryConfig {

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        return new PaginationInnerInterceptor();
    }

}
