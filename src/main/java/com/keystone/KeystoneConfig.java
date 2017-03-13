package com.keystone;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Spring configuration class. The project uses JavaConfig instead of XML based Spring configuration
 */

@Configuration
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration(exclude = LiquibaseAutoConfiguration.class)
@ComponentScan(basePackageClasses = {KeystoneScannable.class})
public class KeystoneConfig {

    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("")
                .url("jdbc:h2:mem:")
                .driverClassName("org.h2.Driver")
                .build();
    }
}
