package kr.or.chan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.or.chan"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
