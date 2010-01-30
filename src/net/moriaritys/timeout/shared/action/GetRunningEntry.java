package net.moriaritys.timeout.shared.action;

import net.customware.gwt.dispatch.shared.Action;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.result.GetEntryResult;

/**
 *
 */
public class GetRunningEntry implements Action<GetEntryResult> {
    private WorkLog log;

    private GetRunningEntry() {}

    public GetRunningEntry(final WorkLog log) {
        this.log = log;
    }

    public WorkLog getLog() {
        return log;
    }
}
