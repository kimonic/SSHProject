package mspring4.S_3_1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Qualifier("magic") bean限定符,用于作为bean的唯一标识,
 * 防止spring自动注入时存在不确定情况下使用
 *
 * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE),每次生成全新的对象
 * 声明bean的作用域,默认的是单例模式,使用该注释进行指定
 */
@SuppressWarnings("JavaDoc")
@Component
@Qualifier("magic")
@Cold
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MagicBean {

    private String  name;
    private String  password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
