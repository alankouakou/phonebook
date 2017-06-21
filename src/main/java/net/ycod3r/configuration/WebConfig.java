package net.ycod3r.configuration;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
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
@PropertySource("classpath:static/config.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Value("${upload.location}")
	private static String LOCATION;

	@Value("${upload.maxfilesize}")
	private static long MAX_FILE_SIZE;

	@Value("${upload.maxrequestsize}")
	private static long MAX_REQUEST_SIZE;
	
	@Value("${upload.filesizethreshold}")
	private static int FILE_SIZE_THRESHOLD;

	// Size threshold after which files will be written to disk

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public GroupService departmentService() {
		return new GroupService();
	}

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setName("phonebook.db");
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).build();
		return db;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/employees/**");
		// super.addInterceptors(registry);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new EmployeeConverter(employeeService()));
		registry.addConverter(new DepartmentConverter(departmentService()));
	}

	@Bean
	public ViewResolver viewResolver() {
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

	@Bean(name="multipartResolver")
	public StandardServletMultipartResolver getMultipartResolver() {
		StandardServletMultipartResolver resolver;
		resolver = new StandardServletMultipartResolver();
		return resolver;
	}
	
	@Bean(name="multipartConfigElement")
	public MultipartConfigElement getMultipartConfigElement(){
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION,MAX_FILE_SIZE,MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}
}
