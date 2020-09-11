package net.moxuan.admin;

import lombok.extern.slf4j.Slf4j;
import net.moxuan.admin.init.SystemInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.net.UnknownHostException;

/**
 * @author: moxuan
 * @description: Springboot 启动类
 */
@Slf4j
@SpringBootApplication(scanBasePackages = { "net.moxuan.common", "net.moxuan.admin" })
public class FlameApplication {
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext context = SpringApplication.run(FlameApplication.class, args);
        SystemInit.init(context);
    }
}
