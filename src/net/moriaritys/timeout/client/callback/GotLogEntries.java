package net.moriaritys.timeout.client.callback;

import net.moriaritys.timeout.shared.data.WorkLogEntry;
import net.moriaritys.timeout.shared.result.GetEntriesResult;

import java.util.List;

/**
 *
 */
public abstract class GotLogEntries extends BaseCallback<GetEntriesResult> {
    @Override
    public void onSuccess(final GetEntriesResult getEntriesResult) {
        got(getEntriesResult.getEntries());
    }

    protected abstract void got(List<WorkLogEntry> entries);
}
