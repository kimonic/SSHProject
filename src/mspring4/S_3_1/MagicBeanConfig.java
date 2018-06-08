package mspring4.S_3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


/**
 * 条件化装配bean
 * 通过@Conditional(MagicExistsCondition.class)来实现
 * 如果MagicExistsCondition.class中的方法matches( context, metadata)
 * 返回true,则实例化,返回false,则不实例化
 *
 * #修改properties文件的默认编码方式的方法
 * #settings-->file encodings-->default encodings for properties
 * disc.name=亦筝笙
 * disc.password=12345678
 *
 * @PropertySource() 导入properties文件时,必须注意该文件的编码方式,否则可能导致中文乱码
 *
 *  @Value("${name}") String name,使用占位符的方式解析properties文件
 */
@SuppressWarnings("JavaDoc")
@Configuration
@ComponentScan
@PropertySource(value = "classpath:/mspring4/S_3_1/app.properties",encoding="utf-8" )
public class MagicBeanConfig {

    @Autowired
    Environment environment;

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//        return new PropertySourcesPlaceholderConfigurer();
//    }

    @Bean
    MagicBean magicBean(
            @Value("${name}") String name,
            @Value("${password}") String password
    ){
        MagicBean magicBean=new MagicBean();
//        magicBean.setName(environment.getProperty("name"));
//        magicBean.setPassword(environment.getProperty("password"));
        System.out.println(name);
        System.out.println(password);
        magicBean.setName(name);
        magicBean.setPassword(password);
        return magicBean;
    }
}
