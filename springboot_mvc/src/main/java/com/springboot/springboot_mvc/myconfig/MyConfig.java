package com.springboot.springboot_mvc.myconfig;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfig  {

    //使用WebMvcConfigurerAdapter拓展springboot对springMvc的配置
    @Bean//只要WebMvcConfigurerAdapter 配置到容器他的组件就都会起作用
    public WebMvcConfigurerAdapter  adapter(){

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            //注册拦截器
         /*   @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor())
                        //拦截路路径
                        .addPathPatterns("/**")
                        //不拦截路径
                        .excludePathPatterns("/","/index.html","/login");
            }
*/
            //创建匿名类内部类实现addViewControllers方法  从而实现不访问任何页面 或者访问index.html都会跳转到templates/index.html
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
              registry.addViewController("/").setViewName("index");
              registry.addViewController("/index.html").setViewName("index");
              registry.addViewController("/main.html").setViewName("dashboard");


            }
        };
return adapter;
    }





}
