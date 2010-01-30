package net.moriaritys.timeout.server.dispatch;

import com.google.appengine.api.users.UserService;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import net.moriaritys.timeout.server.dao.WorkLogEntryDao;
import net.moriaritys.timeout.shared.action.GetRunningEntry;
import net.moriaritys.timeout.shared.result.GetEntryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class GetRunningEntryHandler implements ActionHandler<GetRunningEntry, GetEntryResult> {
    private final UserService userService;
    private final WorkLogEntryDao entryDao;

    @Autowired
    public GetRunningEntryHandler(final UserService userService, final WorkLogEntryDao entryDao) {
        this.userService = userService;
        this.entryDao = entryDao;
    }

    @Override
    public Class<GetRunningEntry> getActionType() {
        return GetRunningEntry.class;
    }

    @Override
    public GetEntryResult execute(final GetRunningEntry getRunningEntry,
                                  final ExecutionContext executionContext) throws ActionException {
        return new GetEntryResult(entryDao.getRunningEntry(userService.getCurrentUser(), getRunningEntry.getLog()));
    }

    @Override
    public void rollback(final GetRunningEntry getRunningEntry,
                         final GetEntryResult getEntryResult,
                         final ExecutionContext executionContext) throws ActionException {
    }
}
