package com.wang.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @auth admin
 * @date
 * @Description
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    //配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket getUserDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("后台管理")//api标题
                .description("后台管理相关接口描述")//api描述
                .version("1.0.0")//版本号
                .contact("122333@qq.com")//本API负责人的联系信息
                .license("版权归xxx所有")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)//文档类型（swagger2）
                .apiInfo(apiInfo)//设置包含在json ResourceListing响应中的api元信息
                .select()//启动用于api选择的构建器
                .apis(RequestHandlerSelectors.basePackage("com.wang.controller"))//扫描接口的包
                .paths(PathSelectors.any())//路径过滤器（扫描所有路径）
                .build();
    }
}
