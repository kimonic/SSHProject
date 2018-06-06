package mjava.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class LoginDAO {

    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate==null){
            hibernateTemplate=new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }


    public void  saveBean(LoginBean loginBean){
        //此行代码为暴力解决"Write operations are not allowed in read-only mode (FlushMode.MANUAL): "+
        //					"Turn your Session into FlushMode.COMMIT/AUTO or remove 'readOnly' marker
        // from transaction definition."异常,并没有从根本上解决问题

        getHibernateTemplate().setCheckWriteOperations(false);
        getHibernateTemplate().save(loginBean);
    }
}
