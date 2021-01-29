package pers.tom.docrepository;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tom
 * @description 文档存储库启动类
 * @date 2021/1/28 22:09
 */
@SpringBootApplication
@MapperScan
public class DocRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocRepositoryApplication.class, args);
    }
}
