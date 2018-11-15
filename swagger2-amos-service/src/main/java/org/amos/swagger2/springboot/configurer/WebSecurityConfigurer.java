package org.amos.swagger2.springboot.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    	
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        
    	httpSecurity
		.csrf()
		.disable()// 禁用 Spring Security 自带的跨域处理
		.sessionManagement() // 定制我们自己的 session 策略
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 调整为让 Spring Security 不创建和使用 session
        ;
		// 禁用缓存
		httpSecurity.headers().cacheControl();
    	
    }

}
