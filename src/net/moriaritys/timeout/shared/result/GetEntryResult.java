package net.moriaritys.timeout.shared.result;

import net.customware.gwt.dispatch.shared.Result;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

/**
 *
 */
public class GetEntryResult implements Result {
    private WorkLogEntry entry;

    private GetEntryResult() {}

    public GetEntryResult(final WorkLogEntry entry) {
        this.entry = entry;
    }

    public WorkLogEntry getEntry() {
        return entry;
    }
}
