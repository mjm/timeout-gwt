package net.moriaritys.timeout.client.callback;

import net.moriaritys.timeout.shared.data.WorkLogEntry;
import net.moriaritys.timeout.shared.result.GetEntryResult;

/**
 *
 */
public abstract class GotLogEntry extends BaseCallback<GetEntryResult> {
    @Override
    public void onSuccess(final GetEntryResult getEntryResult) {
        got(getEntryResult.getEntry());
    }

    protected abstract void got(WorkLogEntry entry);
}
