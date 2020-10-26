package com.sanyue.swag.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author BoLin
 * @create 2020-10-20 17:26
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置多个分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置swagger docket实例
    @Bean
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("dev","test");

        //获取项目的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Tommy")
                .apiInfo(apiInfo())
                //配置开关
                .enable(flag)
                .select()
                //配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.sanyue.swag.controller"))
                //过滤
                .paths(PathSelectors.ant("/swag/**"))
                .build();
    }

    Contact contact = new Contact("tommy","http://wwww.baidu.com","286322812@qq.com");
    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        return new ApiInfo("Tommy",
                "即使再小的帆也能远航",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
