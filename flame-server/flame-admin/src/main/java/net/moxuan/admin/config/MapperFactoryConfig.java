package net.moxuan.admin.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: moxuan
 * @description:
 */
@Configuration
public class MapperFactoryConfig {
    @Bean
    public MapperFactory getFactory(){
        return new DefaultMapperFactory.Builder().build();
    }
}
