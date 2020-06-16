package net.moxuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: moxuan
 * @description: Springboot 启动类
 */
@SpringBootApplication
@MapperScan({"net.moxuan.system.mapper", "com.baidu.fsg.uid.worker.dao"})
public class FlameApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlameApplication.class, args);
    }
}
