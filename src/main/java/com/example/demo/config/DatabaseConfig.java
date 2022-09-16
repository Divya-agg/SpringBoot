package com.example.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class DatabaseConfig {

    public DataSource get(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
