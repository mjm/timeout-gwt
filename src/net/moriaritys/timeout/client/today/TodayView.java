package net.moriaritys.timeout.client.today;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import net.moriaritys.timeout.client.entries.EntriesPresenter;
import net.moriaritys.timeout.client.entries.EntriesView;
import net.moriaritys.timeout.client.today.TodayPresenter.Display;

/**
 *
 */
public class TodayView extends Composite implements Display {
    static interface Binder extends UiBinder<FlowPanel, TodayView> {
    }

    private static final Binder binder = GWT.create(Binder.class);

    private static class LabelValueWrapper extends Widget implements HasValue<String> {
        private final Label label;

        public LabelValueWrapper(final Label label) {
            this.label = label;
        }

        @Override
        public String getValue() {
            return label.getText();
        }

        @Override
        public void setValue(final String value) {
            label.setText(value);
        }

        @Override
        public void setValue(final String value, final boolean fireEvents) {
            setValue(value);

            if (fireEvents) {
                ValueChangeEvent.fire(this, value);
            }
        }

        @Override
        public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<String> stringValueChangeHandler) {
            return addHandler(stringValueChangeHandler, ValueChangeEvent.getType());
        }
    }

    @UiField
    Label label;
    @UiField(provided = true)
    EntriesView entries;

    private HasValue<String> labelWrapper;

    @Inject
    TodayView(final EntriesPresenter.Display entries) {
        this.entries = (EntriesView) entries;

        FlowPanel panel = binder.createAndBindUi(this);
        labelWrapper = new LabelValueWrapper(label);

        initWidget(panel);
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    @Override
    public HasValue<String> getDateLabel() {
        return labelWrapper;
    }
}
