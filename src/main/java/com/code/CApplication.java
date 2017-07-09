package com.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/6/12.
 */
@SpringBootApplication
public class CApplication {
    public  static void main(String args[]){
        SpringApplication application = new SpringApplication(CApplication.class);
        //application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
