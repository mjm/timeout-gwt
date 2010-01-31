package net.moriaritys.timeout.client.ui;

import net.customware.gwt.presenter.client.Display;

/**
 *
 */
public interface HasRows<D extends Display> {
    void clearRows();

    void addRow(D display);
}
