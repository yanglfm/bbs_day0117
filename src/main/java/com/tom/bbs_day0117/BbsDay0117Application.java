package com.tom.bbs_day0117;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.tom.bbs_day0117.mapper")
public class BbsDay0117Application {

    public static void main(String[] args) {
        SpringApplication.run(BbsDay0117Application.class, args);
        System.out.println("123GO");
    }

}

