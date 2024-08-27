package com.zyc.service.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 作者:ZYC
 * DATE:2024/8/27
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@SpringBootApplication(scanBasePackages = "com.zyc")
public class HZBApplication {
    public static void main(String[] args) {
        SpringApplication.run(HZBApplication.class, args);
    }
}
