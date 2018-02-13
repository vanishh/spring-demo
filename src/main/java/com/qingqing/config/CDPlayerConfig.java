package com.qingqing.config;

import com.qingqing.CDPlayer;
import com.qingqing.CompactDisc;
import com.qingqing.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 注解在spring中启动组件扫描，默认会扫描与配置类（即当前类）相同的包
// 使用字符串形式：
// 如果想扫描其他的基础包，@ComponentScan("com.xxx.xx") 或者@ComponentScan(basePackages = "com.xxx")
// 扫描多个基础包：@ComponentScan(basePackages = {"com.xxx.package1", "com.xxx.package2"})
// 使用类形式：
// 扫描类所在的包做为基础包：@ComponentScan(basePackageClasses= {CDPlayer.class, DVDPlayer.class})
//@ComponentScan(basePackages = "com.qingqing")

// 使用@Configuration注解来进行显式的装配CDPlayer、CompactDisc
@Configuration
public class CDPlayerConfig {

    // 编写一个方法，返回所需类型的实例
    // 使用@Bean注解，告诉spring 该对象要注册为Spring 容器中的bean
    // 默认情况下bean 的id,与@Bean注解的方法名相同；或者重新命名id @Bean(name="lonelyHeartClubBand")
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    // bean 的装配
    // 默认情况下，spring中的bean都是单例的。spring会拦截sgtPeppers() 的调用，并返回spring容器中的bean。
    // 所以，CDPlayer中装配的bean 是Spring 容器中同一个bean，没有重新生成一个CompactDisc
    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    // 方式2：
    // spring自动装配一个CompactDisc到方法中
    // 不需要显式要求已经存在创建被注入对象的方法，如sgtPeppers() 即可完成注入
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

}
