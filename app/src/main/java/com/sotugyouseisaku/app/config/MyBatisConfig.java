package com.sotugyouseisaku.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sotugyouseisaku.app.repository")
public class MyBatisConfig {
}