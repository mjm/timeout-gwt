package net.moriaritys.timeout.server.dispatch;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import net.moriaritys.timeout.server.dao.WorkLogEntryDao;
import net.moriaritys.timeout.shared.action.GetCompletedEntries;
import net.moriaritys.timeout.shared.result.GetEntriesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class GetCompletedEntriesHandler implements ActionHandler<GetCompletedEntries, GetEntriesResult> {
    private final UserService userService;
    private final WorkLogEntryDao entryDao;

    @Autowired
    public GetCompletedEntriesHandler(final UserService userService, final WorkLogEntryDao entryDao) {
        this.userService = userService;
        this.entryDao = entryDao;
    }

    @Override
    public Class<GetCompletedEntries> getActionType() {
        return GetCompletedEntries.class;
    }

    @Override
    public GetEntriesResult execute(final GetCompletedEntries getCompletedEntries,
                                    final ExecutionContext executionContext) throws ActionException {
        final User user = userService.getCurrentUser();
        return new GetEntriesResult(entryDao.getCompletedEntries(user, getCompletedEntries.getLog()));
    }

    @Override
    public void rollback(final GetCompletedEntries getCompletedEntries,
                         final GetEntriesResult getEntriesResult,
                         final ExecutionContext executionContext) throws ActionException {
    }
}
