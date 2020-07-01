package com.jobtbao.oauth.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * OkHttpClient配置，使用单例模式，节省资源
 */
@Configuration
@Slf4j
public class OkHttpClientConfig {

    @Bean(value = "okHttpClient")
    public OkHttpClient getClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
//                .connectionPool(new ConnectionPool())
                .retryOnConnectionFailure(true);
        log.info("OkHttpClient 初始化完成，程序中统一使用这个共享实例");
        return builder.build();
    }

}
