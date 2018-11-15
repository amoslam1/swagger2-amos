package org.amos.swagger2.springboot.configurer;

import java.util.ArrayList;
import java.util.List;

import org.amos.framework.annotation.Auto;
import org.amos.publish.PublishSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PublishSwagger2
public class Swagger2Configurer {

	@Bean
	public Docket allApi() {

		// 在配置好的配置类中增加此段代码即可
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("Authorization").description("令牌")// name表示名称，description表示描述
				.modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("Bearer ")
				.build();// required表示是否必填，defaultvalue表示默认值
		pars.add(ticketPar.build());// 添加完此处一定要把下边的带***的也加上否则不生效

		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {

				return true;
			}
		};

	return new Docket(DocumentationType.SWAGGER_2).groupName("所有接口").genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(false).select().apis(predicate)
				.paths(PathSelectors.any())// 过滤的接口
				.build().globalOperationParameters(pars).apiInfo(allApiInfo());
	}

	/**
	 * 定义api组，
	 */
	@Bean
	public Docket api() {

		// 在配置好的配置类中增加此段代码即可
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("Authorization").description("令牌")// name表示名称，description表示描述
				.modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("Bearer ")
				.build();// required表示是否必填，defaultvalue表示默认值
		pars.add(ticketPar.build());// 添加完此处一定要把下边的带***的也加上否则不生效

		@SuppressWarnings("deprecation")
		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				Class<?> declaringClass = input.declaringClass();
				/*
				 * if (declaringClass == TestController.class)// 排除 return
				 * false;
				 */
				if (declaringClass.isAnnotationPresent(Auto.class)) {

					// 被注解的类
					return false;
				}
				if (input.isAnnotatedWith(Auto.class)) {

					// 被注解的方法
					return false;
				}

				return declaringClass(input).transform(handlerPackage("org.amos.swagger2.controller"))
						.or(true);
			}
		};

		return new Docket(DocumentationType.SWAGGER_2).groupName("手写接口").genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(true).select()
				// Predicates.or(predicate,RequestHandlerSelectors.basePackage("org.amos.swagger2.controller"))
				.apis(predicate).paths(PathSelectors.any()).build().globalOperationParameters(pars).apiInfo(apiInfo());
	}

	@SuppressWarnings("deprecation")
	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}

	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
		return new Function<Class<?>, Boolean>() {
			@Override
			public Boolean apply(Class<?> input) {
				return ClassUtils.getPackageName(input).startsWith(basePackage);
			}
		};
	}

	@Bean
	public Docket autoApi() {

		// 在配置好的配置类中增加此段代码即可
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("Authorization").description("令牌")// name表示名称，description表示描述
				.modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("Bearer ")
				.build();// required表示是否必填，defaultvalue表示默认值
		pars.add(ticketPar.build());// 添加完此处一定要把下边的带***的也加上否则不生效

		@SuppressWarnings("deprecation")
		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				Class<?> declaringClass = input.declaringClass();
				/*
				 * if (declaringClass == TestController.class)// 排除 return
				 * false;
				 */

				if (declaringClass.isAnnotationPresent(Auto.class)) {

					// 被注解的类
					return true;
				}

				if (input.isAnnotatedWith(Auto.class)) {

					// 被注解的方法
					return true;
				}
				return false;
			}
		};

		return new Docket(DocumentationType.SWAGGER_2).groupName("生成接口").genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).forCodeGeneration(false).select().apis(predicate)
				.paths(PathSelectors.any())// 过滤的接口
				.build().globalOperationParameters(pars).apiInfo(autoApiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Custom API")// 大标题
				.version("1.0.0")// 版本
				.build();
	}

	private ApiInfo autoApiInfo() {
		return new ApiInfoBuilder().title("Auto API")// 大标题
				.version("1.0.0")// 版本
				.build();
	}

	private ApiInfo allApiInfo() {
		return new ApiInfoBuilder().title("All API")// 大标题
				.version("1.0.0")// 版本
				.build();
	}
}
