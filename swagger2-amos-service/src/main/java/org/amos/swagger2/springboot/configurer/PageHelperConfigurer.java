package org.amos.swagger2.springboot.configurer;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfigurer {
	 
	/**
	 * 
	 * @return
	 */
	@Bean
    public PageHelper pageHelper(){
		
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","MYSQL");
        pageHelper.setProperties(properties);
        
        return pageHelper;
    }

}
