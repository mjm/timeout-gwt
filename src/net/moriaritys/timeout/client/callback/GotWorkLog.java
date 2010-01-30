package net.moriaritys.timeout.client.callback;

import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.result.GetLogResult;

/**
 *
 */
public abstract class GotWorkLog extends BaseCallback<GetLogResult> {
    @Override
    public void onSuccess(final GetLogResult getLogResult) {
        got(getLogResult.getWorkLog());
    }

    protected abstract void got(WorkLog log);
}
