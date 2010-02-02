package net.moriaritys.timeout.client.today;

import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;
import com.google.inject.Provider;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import net.moriaritys.timeout.client.callback.GotLogEntry;
import net.moriaritys.timeout.client.callback.GotWorkLog;
import net.moriaritys.timeout.client.entries.EntriesPresenter;
import net.moriaritys.timeout.client.inject.CurrentDate;
import net.moriaritys.timeout.client.timer.TimerPresenter;
import net.moriaritys.timeout.client.today.TodayPresenter.Display;
import net.moriaritys.timeout.shared.action.GetRunningEntry;
import net.moriaritys.timeout.shared.action.GetTodayLog;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

/**
 *
 */
public class TodayPresenter extends WidgetPresenter<Display> {
    public static interface Display extends WidgetDisplay {
        HasValue<String> getDateLabel();
    }

    private final DispatchAsync dispatch;
    private final EntriesPresenter entries;
    private final TimerPresenter timer;
    private final Provider<String> dateProvider;

    private WorkLog log;

    @Inject
    TodayPresenter(final Display display, final EventBus eventBus, final DispatchAsync dispatch,
                   final EntriesPresenter entries, final TimerPresenter timer,
                   @CurrentDate final Provider<String> dateProvider) {
        super(display, eventBus);
        this.dispatch = dispatch;
        this.entries = entries;
        this.timer = timer;
        this.dateProvider = dateProvider;
    }

    @Override
    protected void onBind() {
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
        dispatch.execute(new GetTodayLog(dateProvider.get()), new GotWorkLog() {
            @Override
            protected void got(final WorkLog log) {
                dispatch.execute(new GetRunningEntry(log), new GotLogEntry() {
                    @Override
                    protected void got(final WorkLogEntry entry) {
                        timer.setEntry(entry);
                        timer.revealDisplay();
                    }
                });

                TodayPresenter.this.log = log;

                display.getDateLabel().setValue(log.getDay());

                entries.setWorkLog(log);
                entries.revealDisplay();
            }
        });
    }
}
