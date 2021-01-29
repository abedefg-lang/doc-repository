package pers.tom.docrepository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lijia
 * @description bean config
 * @date 2021-01-29 14:31
 */
@Configuration
@Import({RepositoryConfig.class})
public class BeanConfig {
}
