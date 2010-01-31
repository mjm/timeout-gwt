package net.moriaritys.timeout.client.ui;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;

import java.util.Date;

/**
 *
 */
public class DateLabel extends Label implements HasValue<Date> {
    private final DateTimeFormat format;
    private Date date;

    public DateLabel() {
        this(DateTimeFormat.getMediumDateFormat());
    }

    public DateLabel(final DateTimeFormat format) {
        this.format = format;
    }

    @Override
    public Date getValue() {
        return date;
    }

    @Override
    public void setValue(final Date date) {
        this.date = date;

        setText(format.format(date));
    }

    @Override
    public void setValue(final Date date, final boolean fireEvents) {
        setValue(date);

        if (fireEvents) {
            ValueChangeEvent.fire(this, date);
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Date> dateValueChangeHandler) {
        return addHandler(dateValueChangeHandler, ValueChangeEvent.getType());
    }
}
