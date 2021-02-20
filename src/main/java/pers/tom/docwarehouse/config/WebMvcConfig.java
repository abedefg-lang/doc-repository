package pers.tom.docwarehouse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.tom.docwarehouse.controller.handler.ApiAuthenticationInterceptor;

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

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

}
