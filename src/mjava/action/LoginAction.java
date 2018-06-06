package mjava.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import mjava.controller.UserManager;
import mjava.controller.UserManagerConfig;
import mjava.dao.LoginBean;
import mjava.dao.LoginConfig;
import mjava.dao.LoginDAO;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Map;

/**
 * structs2在action中自动注入表单属性
 */
public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> request;

    private String name;
    private String password;

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

    @SuppressWarnings("unchecked")
    public LoginAction() {
        ActionContext context=ActionContext.getContext();
        request= (Map<String, Object>) context.get("request");
//        response= (Map<String, Object>) context.get("response");
    }

    @Override
    public String execute() throws Exception {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(LoginConfig.class);
        LoginBean user=context.getBean(LoginBean.class);
        user.setName(name);
        user.setPassword(password);

//        AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext(UserManagerConfig.class);


//        ApplicationContext context1 =new ClassPathXmlApplicationContext("spring-config.xml");
//        LoginDAO userManager= (LoginDAO) context1.getBean("LoginDAO");
        UserManager userManager=context.getBean(UserManager.class);
        userManager.add(user);

        System.out.println("用户名:"+user.getName());
        System.out.println("密码:"+user.getPassword());
        request.put("name",name);
        request.put("password",password);
        context.close();
        return SUCCESS;
    }
}
