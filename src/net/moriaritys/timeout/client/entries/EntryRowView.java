package net.moriaritys.timeout.client.entries;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import net.moriaritys.timeout.client.entries.EntryRowPresenter.Display;
import net.moriaritys.timeout.client.ui.DateLabel;

import java.util.Date;

/**
 *
 */
public class EntryRowView implements Display {
    private final DateLabel startLabel = new DateLabel();
    private final DateLabel endLabel = new DateLabel();

    @Override
    public HasValue<Date> getStartLabel() {
        return startLabel;
    }

    @Override
    public Widget getStartWidget() {
        return startLabel;
    }

    @Override
    public HasValue<Date> getEndLabel() {
        return endLabel;
    }

    @Override
    public Widget getEndWidget() {
        return endLabel;
    }
}
