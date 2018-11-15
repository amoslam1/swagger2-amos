package org.amos.swagger2.springboot.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 指定扫描的mapper接口所在的包，
 * 导入spring boot tk mybatis依赖
 * import tk.mybatis.spring.annotation.MapperScan;
 */
@MapperScan(basePackages = "org.amos.swagger2.mapper")
@ComponentScan(
		basePackages = {
				/**
				 * 扫描spring boot
				 */
				"org.amos.swagger2.springboot.*"
				
				/**
				 * 扫描service
				 */
				,"org.amos.swagger2.service.*"
				
				/**
				 * 扫描controller
				 */
				,"org.amos.swagger2.controller.*"
				
				/**
				 * 扫描全局异常拦截器
				 */
				,"org.amos.swagger2.common.handler"
		}
)

@ImportResource({
	"classpath:/WEB-INF/spring/spring-*.xml"
})

@SpringBootApplication

/**
 * 开启事务管理
 */
@EnableTransactionManagement

/**
 * 开启AspectJ 自动代理模式,缺省false
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		 
		SpringApplication.run(Application.class, args);
		
		LOGGER.info("Spring boot start success ......");
	}
}
