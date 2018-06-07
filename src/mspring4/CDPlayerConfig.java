package mspring4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * * 配置类,spring自动装配示例接口--03
 * @Configuration 配置类的标记
 * @ComponentScan 开启spring的组件扫描注释,自动配置需要的注解
 * 无配置默认扫描与配置类相同的包
 * @ComponentScan("指定要扫描的包,包路径表示")
 * 以basePackages的形式设置多个基础扫描包
 * @ComponentScan(basePackages = {"mjava.dao","mspring4"})
 * 或者设置所包含的类或接口
 * @ComponentScan(basePackageClasses ={CDPlayer.class,DVDPlayer.class })
 * @Bean  显式配置要装配的bean
 * @Bean(name = "sgtPeppers")  配置bean的id,默认值为类名首字母小写
 * 通过@Import(SgtPeppersConfig.class)在本配置文件中导入另外一个配置文件
 */

@SuppressWarnings("JavaDoc")
@Configuration
@ComponentScan
@Import(SgtPeppersConfig.class)
public class CDPlayerConfig {
    @Bean(name = "sgtPeppers")
    CompactDisc compactDisc(){
        return new SgtPeppers();
    }

    @Bean
    CDPlayer cdPlayer(){
        return new CDPlayer(compactDisc());
    }
}
