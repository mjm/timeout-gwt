package net.moriaritys.timeout.server.dao;

import com.google.appengine.api.users.User;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

import java.util.List;

/**
 *
 */
public interface WorkLogEntryDao {
    List<WorkLogEntry> getCompletedEntries(User user, WorkLog log);

    WorkLogEntry getRunningEntry(User user, WorkLog log);

    WorkLogEntry startTimer(User user, WorkLog log);

    void stopTimer(User user, WorkLogEntry entry);
}
