package net.moriaritys.timeout.server.dispatch;

import com.google.appengine.api.users.UserService;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import net.moriaritys.timeout.server.dao.WorkLogEntryDao;
import net.moriaritys.timeout.shared.action.StartTimer;
import net.moriaritys.timeout.shared.result.GetEntryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class StartTimerHandler implements ActionHandler<StartTimer, GetEntryResult> {
    private final UserService userService;
    private final WorkLogEntryDao entryDao;

    @Autowired
    public StartTimerHandler(final UserService userService, final WorkLogEntryDao entryDao) {
        this.userService = userService;
        this.entryDao = entryDao;
    }

    @Override
    public Class<StartTimer> getActionType() {
        return StartTimer.class;
    }

    @Transactional
    @Override
    public GetEntryResult execute(final StartTimer startTimer,
                                  final ExecutionContext executionContext) throws ActionException {
        return new GetEntryResult(entryDao.startTimer(userService.getCurrentUser(), startTimer.getLog()));
    }

    @Override
    public void rollback(final StartTimer startTimer,
                         final GetEntryResult getEntryResult,
                         final ExecutionContext executionContext) throws ActionException {
    }
}
