package com.myapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class MyDbConfiguration {

    @Bean
    public DataSource dataSource() {

	// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
	EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY) // .H2 or .DERBY
		.addScript("db/create-db.sql").addScript("db/insert-data.sql").build();
	return db;
    }
}