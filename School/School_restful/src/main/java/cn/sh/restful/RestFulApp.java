package cn.sh.restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.sh.restful.config.DruidConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletComponentScan
@Configuration
@MapperScan("cn.sh.db.mapper")
public class RestFulApp {
	public static void main(String[] args) {
		SpringApplication.run(RestFulApp.class, args);
	}
}
