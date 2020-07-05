package cn.jijl.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jijl
 * @Date 15:03 2020/7/5
 **/
@Configuration
public class FeignConfig {

    /**
     * @Author jijl
     * @Description: 日志打印几级别
     * NONE：不输出日志
     * BASIC：输出请求方法、URL、响应状态码、执行时间
     * HEADERS：基本信息以及请求和响应头
     * FULL：请求和响应的heads、body、metadata，建议使用这个级别
     * @Date 15:34 2020/7/5
     **/
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
