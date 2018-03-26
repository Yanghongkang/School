package cn.sh.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author adminyhk 懒人建表专用启动
 */
@SpringBootApplication
@MapperScan("cn.sh.db.mapper")
@PropertySource(value = { "classpath:application-datebase.properties" })
public class AppTestSqlApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppTestSqlApplication.class, args);
	}
}
