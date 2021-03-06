/**
 * 
 */
package org.test.document.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.test.document.dao.DocumentDAO;
import org.test.document.service.DocumentService;
import org.test.document.service.impl.DocumentServiceImpl;

/**
 * @author Aaditi Godbole
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.test.document.controller")
public class AppConfig extends WebMvcConfigurerAdapter {

	/**
	 * 
	 */
	public AppConfig() {
		// TODO Auto-generated constructor stub
	}
	@Bean
	 ViewResolver viewResolver(){
		
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			//viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/resources/views/");
			viewResolver.setSuffix("");

			return viewResolver;
	}
	
	@Bean
	DocumentService documentService(){
		return new DocumentServiceImpl();
	}
	
	@Bean
	DocumentDAO documentDao(){
		return new DocumentDAO();
	}
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
		
	}
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;
	}
}
