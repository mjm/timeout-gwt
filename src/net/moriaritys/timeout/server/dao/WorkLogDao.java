package net.moriaritys.timeout.server.dao;

import com.google.appengine.api.users.User;
import net.moriaritys.timeout.shared.data.WorkLog;

import java.util.List;

/**
 *
 */
public interface WorkLogDao {
    List<WorkLog> getAll(User user);

    WorkLog getByKey(User user, Long id);

    WorkLog getOrCreateToday(User user, String today);

    void add(User user, WorkLog log);

    void modify(User user, WorkLog log);

    void remove(User user, Long id);
}
