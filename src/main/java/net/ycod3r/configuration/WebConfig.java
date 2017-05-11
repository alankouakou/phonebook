package net.ycod3r.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import net.ycod3r.interceptors.AuthInterceptor;
import net.ycod3r.service.DepartmentConverter;
import net.ycod3r.service.EmployeeConverter;
import net.ycod3r.service.EmployeeService;
import net.ycod3r.service.GroupService;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public EmployeeService employeeService(){
		return new EmployeeService();
	}
	
	@Bean
	public GroupService departmentService(){
		return new GroupService();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/employees/**");
		//super.addInterceptors(registry);
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new EmployeeConverter(employeeService()));
		registry.addConverter(new DepartmentConverter(departmentService()));
	}
	
	@Bean
	public ViewResolver viewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine() {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.addTemplateResolver(templateResolver());
	    templateEngine.addDialect(new LayoutDialect());
	    return templateEngine;
	}

	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);
		return templateResolver;
	}
}
