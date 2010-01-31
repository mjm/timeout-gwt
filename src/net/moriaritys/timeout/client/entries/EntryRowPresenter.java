package net.moriaritys.timeout.client.entries;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import net.customware.gwt.presenter.client.BasicPresenter;
import net.customware.gwt.presenter.client.EventBus;
import net.moriaritys.timeout.client.entries.EntryRowPresenter.Display;
import net.moriaritys.timeout.shared.data.WorkLogEntry;

import java.util.Date;

/**
 *
 */
public class EntryRowPresenter extends BasicPresenter<Display> {
    public static interface Display extends net.customware.gwt.presenter.client.Display {
        HasValue<Date> getStartLabel();

        Widget getStartWidget();

        HasValue<Date> getEndLabel();

        Widget getEndWidget();
    }

    private WorkLogEntry entry;

    @Inject
    EntryRowPresenter(final Display display, final EventBus eventBus) {
        super(display, eventBus);
    }

    public void setEntry(final WorkLogEntry entry) {
        this.entry = entry;
    }

    @Override
    protected void onBind() {
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
        display.getStartLabel().setValue(entry.getStartTime());
        display.getEndLabel().setValue(entry.getEndTime());
    }
}
