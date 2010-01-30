package net.moriaritys.timeout.shared.action;

import net.customware.gwt.dispatch.shared.Action;
import net.moriaritys.timeout.shared.result.GetLogResult;

/**
 *
 */
public class GetTodayLog implements Action<GetLogResult> {
    private String date;

    private GetTodayLog() {}

    public GetTodayLog(final String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
