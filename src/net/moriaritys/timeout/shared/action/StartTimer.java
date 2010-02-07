package net.moriaritys.timeout.shared.action;

import net.customware.gwt.dispatch.shared.Action;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.result.GetEntryResult;

/**
 *
 */
public class StartTimer implements Action<GetEntryResult> {
    private WorkLog log;

    private StartTimer() {
    }

    public StartTimer(final WorkLog log) {
        this.log = log;
    }

    public WorkLog getLog() {
        return log;
    }
}
