package net.moxuan.common.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: moxuan
 * @description: MapperFactory 配置类
 */
@Configuration
public class MapperFactoryConfig {
    @Bean
    public MapperFactory getFactory(){
        return new DefaultMapperFactory.Builder().build();
    }
}
