package com.springboot.lee.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.springboot.lee.controller")).build();
	}
	
	private ApiInfo apiInfo() {
		
		Contact DEFAULT_CONTACT = new Contact("LEEYuanHao", "https://www.youtube.com/?reload=9&app=desktop&hl=zh-tw", "jasonlee40203006@gmail.com");//作者信息

		
		return new ApiInfo(
				"LEE's API Document",
				"你好我叫李原豪",
				"1.0",
				"https://www.youtube.com/?reload=9&app=desktop&hl=zh-tw",
		        DEFAULT_CONTACT,
		        "Apache 2.0",
		        "http://www.apache.org/licenses/LICENSE-2.0",
		        new ArrayList<VendorExtension>());
	}
}
