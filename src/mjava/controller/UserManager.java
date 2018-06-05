package mjava.controller;


import mjava.dao.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

@Service
public class UserManager extends HibernateDaoSupport {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    private HibernateTemplate ht;


    public UserManager() {
        this.ht = super.getHibernateTemplate();
        System.out.println(ht);
    }

    public void add(LoginBean s)
    {
        System.out.println(ht);
        ht.save(s);//插入一条数据只需要这一行代码
    }
}
