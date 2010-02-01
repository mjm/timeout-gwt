package net.moriaritys.timeout.shared.result;

import net.customware.gwt.dispatch.shared.Result;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

import java.util.List;

/**
 *
 */
public class GetEntriesResult implements Result {
    private List<WorkLogEntry> entries;

    private GetEntriesResult() {
    }

    public GetEntriesResult(final List<WorkLogEntry> entries) {
        this.entries = entries;
    }

    public List<WorkLogEntry> getEntries() {
        return entries;
    }
}
