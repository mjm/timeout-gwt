package net.moriaritys.timeout.client.entries;

import com.google.inject.Inject;
import com.google.inject.Provider;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import net.moriaritys.timeout.client.callback.GotLogEntries;
import net.moriaritys.timeout.client.entries.EntriesPresenter.Display;
import net.moriaritys.timeout.client.ui.HasRows;
import net.moriaritys.timeout.shared.action.GetCompletedEntries;
import net.moriaritys.timeout.shared.data.WorkLog;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

import java.util.List;

/**
 *
 */
public class EntriesPresenter extends WidgetPresenter<Display> {
    public static interface Display extends WidgetDisplay {
        HasRows getEntryRows();
    }

    private final DispatchAsync dispatch;
    private final Provider<EntryRowPresenter> entryRow;

    private WorkLog log;

    @Inject
    EntriesPresenter(final Display display, final EventBus eventBus, final DispatchAsync dispatch,
                     final Provider<EntryRowPresenter> entryRow) {
        super(display, eventBus);
        this.dispatch = dispatch;
        this.entryRow = entryRow;
    }

    public void setWorkLog(final WorkLog log) {
        this.log = log;
    }

    @Override
    protected void onBind() {
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
        dispatch.execute(new GetCompletedEntries(log), new GotLogEntries() {
            @Override
            protected void got(final List<WorkLogEntry> entries) {
                display.getEntryRows().clearRows();

                for (final WorkLogEntry entry : log.getEntries()) {
                    EntryRowPresenter row = entryRow.get();
                    row.setEntry(entry);
                    row.revealDisplay();
                }
            }
        });
    }
}
