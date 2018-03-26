package cn.sh.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("cn.sh.db.mapper")
@PropertySource(value = { "classpath:application-datebase.properties", "application-mvc.properties" })
public class WebSiteApp {
	public static void main(String[] args) {
		System.out.println("------------SpringBoot开始启动------------------");
		SpringApplication.run(WebSiteApp.class, args);
		System.out.println("------------SpringBoot启动完成------------------");
	}

}
