package net.moriaritys.timeout.shared.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Entity
public class WorkLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    // Using a string because we want to represent a day and not worry about time zones
    @Basic(optional = false)
    private String day;
    @Basic(optional = false)
    private String userId;

    public Long getKey() {
        return key;
    }

    public void setKey(final Long key) {
        this.key = key;
    }

    public String getDay() {
        return day;
    }

    public void setDay(final String day) {
        this.day = day;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String user) {
        this.userId = user;
    }
}
