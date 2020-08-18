package net.moxuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: moxuan
 * @description: Springboot 启动类
 */
@ImportResource("classpath:spring-aop.xml")
@MapperScan({"net.moxuan.system.mapper", "com.baidu.fsg.uid.worker.dao"})
@SpringBootApplication
public class FlameApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlameApplication.class, args);
    }
}
