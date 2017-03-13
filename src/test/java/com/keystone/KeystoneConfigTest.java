package com.keystone;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
@Import(KeystoneConfig.class)
@ComponentScan(basePackageClasses = {KeystoneScannable.class})
public class KeystoneConfigTest {

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
