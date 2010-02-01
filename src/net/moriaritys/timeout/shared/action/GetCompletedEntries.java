package net.moriaritys.timeout.shared.action;

import net.customware.gwt.dispatch.shared.Action;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.result.GetEntriesResult;

/**
 *
 */
public class GetCompletedEntries implements Action<GetEntriesResult> {
    private WorkLog log;

    private GetCompletedEntries() {
    }

    public GetCompletedEntries(final WorkLog log) {
        this.log = log;
    }

    public WorkLog getLog() {
        return log;
    }
}
