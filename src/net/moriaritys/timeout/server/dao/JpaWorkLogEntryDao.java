package net.moriaritys.timeout.server.dao;

import com.google.appengine.api.users.User;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.data.WorkLogEntry;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
public class JpaWorkLogEntryDao implements WorkLogEntryDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<WorkLogEntry> getCompletedEntries(final User user, final WorkLog log) {
        Query query = entityManager.createQuery(
                "select e from WorkLogEntry e where e.log = :key and e.endTime is not null");
        query.setParameter("key", log.getKey());
        return new ArrayList<WorkLogEntry>(query.getResultList());
    }

    @Override
    public WorkLogEntry getRunningEntry(final User user, final WorkLog log) {
        try {
            Query query = entityManager.createQuery(
                    "select e from WorkLogEntry e where e.log = :log and e.endTime is null");
            query.setParameter("log", log);
            return (WorkLogEntry) query.getSingleResult();
        } catch (final NoResultException e) {
            WorkLogEntry entry = new WorkLogEntry();
            entry.setLog(log);
            return entry;
        }
    }

    @Override
    public WorkLogEntry startTimer(final User user, final WorkLog log) {
        WorkLogEntry entry = getRunningEntry(user, log);

        if (entry.getStartTime() == null) {
            entry.setStartTime(new Date());
            entityManager.persist(entry);
        }

        return entry;
    }

    @Override
    public void stopTimer(final User user, final WorkLogEntry entry) {
        entry.setEndTime(new Date());
        entityManager.merge(entry);
    }
}
