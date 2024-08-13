package com.glf.service3.config;

import io.swagger.annotations.ApiOperation;
//import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;
import java.util.List;

//@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

//    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .contact(new Contact("zwy","http://120.24.28.124","xiaoyang@heypad.cn"))
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("个人学习网站")
                        .termsOfServiceUrl("http://120.24.28.124")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("1.0.0版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes());
    }

    /**
     * 安全模式，这里配置通过请求头 openid传递 openid 参数
     */
    private static List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey("openid", "openid", "header"));
    }
}
