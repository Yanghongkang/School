package org.School_model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author adminyhk 懒人建表专用启动
 */
@SpringBootApplication
// @PropertySource(value = { "classpath:dataSource.properties" })
public class AppCreateDb {
	public static void main(String[] args) {
		SpringApplication.run(AppCreateDb.class, args);
	}
}
