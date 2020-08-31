package net.moxuan.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: moxuan
 * @description: Springboot 启动类
 */
@SpringBootApplication(scanBasePackages = { "net.moxuan.entity", "net.moxuan.service", "net.moxuan.common", "net.moxuan.admin" })
//@MapperScan({"net.moxuan.mapper"})
public class FlameApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlameApplication.class, args);
    }
}
