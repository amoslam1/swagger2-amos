package org.amos.swagger2.springboot.configurer;

import org.amos.swagger2.common.constants.Constants;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration	
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, Constants.SYSTEM_EXCEPTION));
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/400"));
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_GATEWAY, Constants.SYSTEM_EXCEPTION));
                container.addErrorPages(new ErrorPage(Throwable.class, Constants.SYSTEM_EXCEPTION));
            }
        };
    }
	
	/**
	 * swagger-ui配置
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
