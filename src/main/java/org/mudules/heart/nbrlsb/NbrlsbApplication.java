package org.mudules.heart.nbrlsb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.mudules.heart.nbrlsb.*.mapper")
//@EnableAsync
public class NbrlsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbrlsbApplication.class, args);
        System.out.println();
    }

}
