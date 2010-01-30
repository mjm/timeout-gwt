package net.moriaritys.timeout.client.callback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 */
public abstract class BaseCallback<T> implements AsyncCallback<T> {
    @Override
    public void onFailure(final Throwable throwable) {
        GWT.log("Action failure", throwable);
    }
}
