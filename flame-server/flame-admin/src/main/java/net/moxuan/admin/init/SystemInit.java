package net.moxuan.admin.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: moxuan
 * @description:
 */
@Slf4j
public class SystemInit {

    public static void init(ApplicationContext context) throws UnknownHostException {
        if (log.isInfoEnabled()) {
            Environment environment = context.getEnvironment();
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = environment.getProperty("server.port");
            String path = environment.getProperty("server.servlet.context-path");
            log.info("Local: http://localhost:{}{}", port, path);
            log.info("External: http://{}:{}{}", ip, port, path);
        }
    }
}
