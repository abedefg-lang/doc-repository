package pers.tom.docwarehouse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.tom.docwarehouse.controller.supports.ApiAuthenticationInterceptor;

/**
 * @author tom
 * @description web mvc config
 * @date 2021/1/30 22:49
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final ApiAuthenticationInterceptor authenticationInterceptor;

    public WebMvcConfig(ApiAuthenticationInterceptor authenticationInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor);
    }
}
