package rain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/** @Configuration class must have at least one @Bean method;
 * in this case we create the ViewResolver.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "rain")
public class Config {
	public Config() {
		System.out.println("Config.viewResolver()");
	}

	/**
	 * Provide a View Resolver
	 * @author Based on 
	 * https://websystique.com/springmvc/spring-4-mvc-helloworld-tutorial-annotation-javaconfig-full-example
	 * @return a View Resolver
	 */
	@Bean
	public ViewResolver viewResolver() {
		System.out.println("Config.viewResolver()");
		InternalResourceViewResolver viewResolver = 
			new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/enquiry/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
