package pers.tom.docwarehouse;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author tom
 * @description 文档存储库启动类
 * @date 2021/1/28 22:09
 */
@SpringBootApplication
@MapperScan("pers.tom.docwarehouse.mapper")
@EnableAsync
@EnableCaching
public class DocWarehouseApplication {

    public static void main(String[] args) {

        SpringApplication.run(DocWarehouseApplication.class, args);
    }
}
