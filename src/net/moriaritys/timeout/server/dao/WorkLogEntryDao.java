package net.moriaritys.timeout.server.dao;

import com.google.appengine.api.users.User;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

/**
 *
 */
public interface WorkLogEntryDao {
    WorkLogEntry getRunningEntry(User user, WorkLog log);

    WorkLogEntry startTimer(User user, WorkLog log);

    void stopTimer(User user, WorkLogEntry entry);
}
