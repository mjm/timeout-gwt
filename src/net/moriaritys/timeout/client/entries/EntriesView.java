package net.moriaritys.timeout.client.entries;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import net.moriaritys.timeout.client.entries.EntriesPresenter.Display;
import net.moriaritys.timeout.client.ui.HasRows;

/**
 *
 */
public class EntriesView extends Composite implements Display, HasRows<EntryRowPresenter.Display> {
    static interface Binder extends UiBinder<DockLayoutPanel, EntriesView> {
    }

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    FlexTable table;

    @Inject
    EntriesView() {
        DockLayoutPanel panel = binder.createAndBindUi(this);
        initWidget(panel);
    }

    @Override
    public void clearRows() {
        table.removeAllRows();
    }

    @Override
    public void addRow(final EntryRowPresenter.Display display) {
        final int row = table.getRowCount();
        int col = 0;

        table.setWidget(row, col++, display.getStartWidget());
        table.setWidget(row, col, display.getEndWidget());
    }

    @Override
    public HasRows getEntryRows() {
        return this;
    }

    @Override
    public Widget asWidget() {
        return this;
    }
}
