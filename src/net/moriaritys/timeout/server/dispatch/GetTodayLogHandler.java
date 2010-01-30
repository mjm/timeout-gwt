package net.moriaritys.timeout.server.dispatch;

import com.google.appengine.api.users.UserService;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import net.moriaritys.timeout.server.dao.WorkLogDao;
import net.moriaritys.timeout.shared.action.GetTodayLog;
import net.moriaritys.timeout.shared.result.GetLogResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class GetTodayLogHandler implements ActionHandler<GetTodayLog, GetLogResult> {
    private final UserService userService;
    private final WorkLogDao logDao;

    @Autowired
    public GetTodayLogHandler(final UserService userService, final WorkLogDao workLogDao) {
        this.userService = userService;
        this.logDao = workLogDao;
    }

    @Override
    public Class<GetTodayLog> getActionType() {
        return GetTodayLog.class;
    }

    @Transactional
    @Override
    public GetLogResult execute(final GetTodayLog getTodayLog,
                                final ExecutionContext executionContext) throws ActionException {
        return new GetLogResult(logDao.getOrCreateToday(userService.getCurrentUser()));
    }

    @Override
    public void rollback(final GetTodayLog getTodayLog,
                         final GetLogResult getLogResult,
                         final ExecutionContext executionContext) throws ActionException {
    }
}
