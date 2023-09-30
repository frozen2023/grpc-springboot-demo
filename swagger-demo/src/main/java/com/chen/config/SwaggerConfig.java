package com.chen.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(Environment environment) {
        //版本选择OAS3
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //根据环境判断是否启用Swagger
                .enable(environment.acceptsProfiles(Profiles.of("dev","test")))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chen.controller"))//扫描的包路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Project Swagger3")
                .description("Welcome to Project's swagger!")
                //.termsOfServiceUrl("你的项目地址")
                .version("1.0")
                .contact(new Contact("Frozen", "个人网站地址", "2095637923@qq.com"))
                .build();
    }

}
