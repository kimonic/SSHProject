package mspring4.S_3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;


/**
 * 条件化装配bean
 * 通过@Conditional(MagicExistsCondition.class)来实现
 * 如果MagicExistsCondition.class中的方法matches( context, metadata)
 * 返回true,则实例化,返回false,则不实例化
 */
@Configuration
@ComponentScan
@PropertySource("classpath:/mspring4/S_3_1/app.properties")
public class MagicBeanConfig {

    @Autowired
    Environment environment;

    @Bean
    MagicBean magicBean(){
        MagicBean magicBean=new MagicBean();
        magicBean.setName(environment.getProperty("disc.name"));
        magicBean.setPassword(environment.getProperty("disc.password"));
        return magicBean;
    }
}
