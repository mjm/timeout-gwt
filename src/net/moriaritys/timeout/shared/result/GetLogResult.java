package net.moriaritys.timeout.shared.result;

import net.customware.gwt.dispatch.shared.Result;
import net.moriaritys.timeout.shared.data.WorkLog;

/**
 *
 */
public class GetLogResult implements Result {
    private WorkLog workLog;

    private GetLogResult() {}

    public GetLogResult(final WorkLog workLog) {
        this.workLog = workLog;
    }

    public WorkLog getWorkLog() {
        return workLog;
    }
}
