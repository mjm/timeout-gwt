package net.moriaritys.timeout.client.convert;

import com.google.gwt.i18n.client.NumberFormat;

/**
 *
 */
public class DurationConverter {

    private static final String NULL = "--:--";
    private static final String NULL_WITH_SECONDS = "--:--:--";

    public Integer from(final String str) {
        final String[] parts = str.split(":");

        int hours = Integer.parseInt(parts[0], 10);
        int minutes = Integer.parseInt(parts[1], 10);
        int seconds = 0;
        if (parts.length >= 3) {
            seconds = Integer.parseInt(parts[2], 10);
        }

        return seconds + (60 * minutes) + (3600 * hours);
    }

    public String to(final Integer dur) {
        return to(dur, true);
    }

    public String to(final Integer dur, final boolean includeSeconds) {
        if (dur == null) {
            return includeSeconds ? NULL_WITH_SECONDS : NULL;
        }

        int hours = dur / 3600;
        int minSec = dur % 3600;
        int minutes = minSec / 60;
        int seconds = minSec % 60;

        final NumberFormat hourFormat = NumberFormat.getFormat("0");
        final NumberFormat format = NumberFormat.getFormat("00");

        StringBuilder sb = new StringBuilder(hourFormat.format(hours) + ":" + format.format(minutes));
        if (includeSeconds) {
            sb.append(":").append(format.format(seconds));
        }

        return sb.toString();
    }
}
