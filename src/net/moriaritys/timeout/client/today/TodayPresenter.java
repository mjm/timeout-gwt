package net.moriaritys.timeout.client.today;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.inject.Inject;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import net.moriaritys.timeout.client.today.TodayPresenter.Display;
import net.moriaritys.timeout.shared.action.GetTodayLog;
import net.moriaritys.timeout.shared.result.GetLogResult;

/**
 *
 */
public class TodayPresenter extends WidgetPresenter<Display> {
    public static interface Display extends WidgetDisplay {
        HasText getLabel();
    }

    private final DispatchAsync dispatch;

    @Inject
    TodayPresenter(final Display display, final EventBus eventBus, final DispatchAsync dispatch) {
        super(display, eventBus);
        this.dispatch = dispatch;
    }

    @Override
    protected void onBind() {
    }

    @Override
    protected void onUnbind() {
    }

    @Override
    protected void onRevealDisplay() {
        dispatch.execute(new GetTodayLog(), new AsyncCallback<GetLogResult>() {
            @Override
            public void onFailure(final Throwable throwable) {

            }

            @Override
            public void onSuccess(final GetLogResult getLogResult) {
                display.getLabel().setText("" + getLogResult.getWorkLog().getDay() + ": " + getLogResult.getWorkLog().getKey());
            }
        });
    }
}
