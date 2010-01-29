package net.moriaritys.timeout.server.dao;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;
import net.moriaritys.timeout.shared.data.WorkLog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 */
@Repository
public class JpaWorkLogDao implements WorkLogDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<WorkLog> getAll(final User user) {
        Query query = entityManager.createQuery("select log from WorkLog log where log.user = :user");
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public WorkLog getByKey(final User user, final Key key) {
        Query query = entityManager.createQuery(
                "select log from WorkLog log where log.key = :key and log.user = :user");
        query.setParameter("key", key);
        query.setParameter("user", user);
        return (WorkLog) query.getSingleResult();
    }

    @Override
    public void add(final User user, final WorkLog log) {
        log.setUser(user);
        entityManager.persist(log);
    }

    @Override
    public void modify(final User user, final WorkLog log) {
        WorkLog existingLog = getByKey(user, log.getKey());
        if (existingLog == null) {
            // TODO maybe throw an exception
            return;
        }

        log.setUser(user);
        entityManager.merge(log);
    }

    @Override
    public void remove(final User user, final Key key) {
        Query query = entityManager.createQuery("delete from WorkLog log where log.key = :key and log.user = :user");
        query.setParameter("key", key);
        query.setParameter("user", user);
        query.executeUpdate();
    }
}
