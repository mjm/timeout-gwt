package net.moriaritys.timeout.server.dao;

import com.google.appengine.api.users.User;
import net.moriaritys.timeout.shared.data.WorkLog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
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
        Query query = entityManager.createQuery("select log from WorkLog log where log.userId = :user");
        query.setParameter("user", user.getUserId());
        return query.getResultList();
    }

    @Override
    public WorkLog getByKey(final User user, final Long key) {
        Query query = entityManager.createQuery(
                "select log from WorkLog log where log.key = :key and log.userId = :user");
        query.setParameter("key", key);
        query.setParameter("user", user.getUserId());
        return (WorkLog) query.getSingleResult();
    }

    @Override
    public WorkLog getOrCreateToday(final User user) {
        WorkLog log;
        Date curDate = getCurrentDate();

        try {
            Query query = entityManager.createQuery(
                    "select log from WorkLog log where log.userId = :user and log.day = :day");
            query.setParameter("user", user.getUserId());
            query.setParameter("day", curDate);
            log = (WorkLog) query.getSingleResult();
        } catch (final NoResultException e) {
            log = new WorkLog();
            log.setDay(curDate);
            log.setUserId(user.getUserId());
            log = entityManager.merge(log);
        }

        return log;
    }

    private Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear(Calendar.HOUR_OF_DAY);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();
    }

    @Override
    public void add(final User user, final WorkLog log) {
        log.setUserId(user.getUserId());
        entityManager.persist(log);
    }

    @Override
    public void modify(final User user, final WorkLog log) {
        WorkLog existingLog = getByKey(user, log.getKey());
        if (existingLog == null) {
            // TODO maybe throw an exception
            return;
        }

        log.setUserId(user.getUserId());
        entityManager.merge(log);
    }

    @Override
    public void remove(final User user, final Long key) {
        Query query = entityManager.createQuery("delete from WorkLog log where log.key = :key and log.userId = :user");
        query.setParameter("key", key);
        query.setParameter("user", user.getUserId());
        query.executeUpdate();
    }
}
