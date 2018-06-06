package mjava.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import mjava.controller.UserManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.CommonDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("mjava.dao")
public class LoginConfig {
    @Bean
    LocalSessionFactoryBean localSessionFactoryBean() throws PropertyVetoException {
        LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(comboPooledDataSource());
        Properties properties=new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setMappingResources("mjava/dao/LoginBean.hbm.xml");
        return localSessionFactoryBean;
        /**
         */
    }

    @Bean
    UserManager userManager() throws PropertyVetoException {
        return new UserManager(localSessionFactoryBean());
    }

    @Bean
    ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/xh_database?serverTimezone=GMT");
        dataSource.setUser("root");
        dataSource.setPassword("dingzhixin");
        return dataSource;
    }

}
