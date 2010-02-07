package net.moriaritys.timeout.client.convert;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

/**
 *
 */
public class TimeConverter {
    private final DateTimeFormat format = DateTimeFormat.getFormat("hh:mm aa");

    public Date from(final String str) {
        return format.parse(str);
    }

    public String to(final Date date) {
        if (date == null) {
            return "--:--";
        }

        return format.format(date);
    }
}
