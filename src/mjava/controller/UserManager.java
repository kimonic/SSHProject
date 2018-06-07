package mjava.controller;


import mjava.dao.LoginBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserManager extends HibernateDaoSupport {

    private LocalSessionFactoryBean sessionFactory;
    private HibernateTemplate ht;



    public void setSessionFactory1(LocalSessionFactoryBean sessionFactory1) {
        this.sessionFactory = sessionFactory1;
    }

    public HibernateTemplate getHt() {

        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }
//17852526666
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }



    @Autowired
    public UserManager(LocalSessionFactoryBean sessionFactory) {
        setSessionFactory(sessionFactory.getObject());
        this.ht = super.getHibernateTemplate();
    }
    @Transactional
    public void add(LoginBean s) {
        System.out.println(ht);
        ht.setCheckWriteOperations(false);
        ht.save(s);//插入一条数据只需要这一行代码
    }
}
