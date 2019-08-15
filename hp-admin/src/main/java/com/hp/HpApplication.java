package com.hp;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动程序
 * 此处去掉权限验证SecurityAutoConfiguration  防止对activiti进行验证
 * @author hp
 */
@EnableCaching
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })
@MapperScan("com.hp.*.mapper")
public class HpApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HpApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}