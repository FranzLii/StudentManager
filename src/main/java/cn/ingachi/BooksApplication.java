package cn.ingachi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.swing.*;

@SpringBootApplication
@MapperScan("cn.ingachi.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class BooksApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BooksApplication.class).headless(false).run(args);
    }
}
