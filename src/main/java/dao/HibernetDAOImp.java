package dao;

import com.mysql.cj.Query;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.transaction.Transactional;
import java.util.List;

public class HibernetDAOImp implements DAO {

    private SessionFactory sessionFactory;

    public HibernetDAOImp(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    @Transactional
    public boolean insertUser(User user) {
        sessionFactory.openSession().save(user);
        return true;
    }
    @Transactional
    public boolean deleteUser(User user) {
        sessionFactory.openSession().delete(user);
        return true;
    }
    @Transactional
    public boolean updateUser(User user) {
        sessionFactory.openSession().update(user);
        return true;
    }
    @Transactional
    public User getUser(int id) {
        return sessionFactory.openSession().get(User.class,id);
    }
    @Transactional
    public User getUserByLogin(String login) {
        org.hibernate.query.Query query = sessionFactory.openSession().createQuery("FROM User WHERE login = :param");
        query.setParameter("param", login);
        return  (User) query.uniqueResult();
    }
    @Transactional
    public List<User> getListOfAllUsers() {
        List<User> users = (List<User>) sessionFactory.openSession().createQuery("FROM User").list();
        return users ;
    }
}
